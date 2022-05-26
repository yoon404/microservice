package com.gxu.sp04.order.service;

import com.gxu.sp01.service.OrderService;
import com.gxu.sp01.service.pojo.Item;
import com.gxu.sp01.service.pojo.Order;
import com.gxu.sp01.service.pojo.User;
import com.gxu.sp04.order.entity.OrderEntity;
import com.gxu.sp04.order.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * 功能描述
 *
 * @author caoyuyi
 * @version 1.0
 * @date 2022/5/22 12:44:45
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    private static final int SHORT_MAX = 65536;
    private static int counter = -1;
    @Autowired
    private OrderMapper orderMapper;

    public static synchronized long nextId() {
        long now = System.currentTimeMillis();
        if (counter == -1) {
            long seed = now ^ Thread.currentThread().getId();
            Random rnd = new Random(Long.hashCode(seed));
            counter = rnd.nextInt(SHORT_MAX);
        }
        long id = (now << 16) | counter;
        counter = (counter + 1) % SHORT_MAX;
        return id;
    }

    @Override
    public Order getOrder(Long orderId) {
        User user = orderMapper.selectUserByOrderId(orderId);
        List<Item> items = orderMapper.selectItemByOrderId(orderId);
        return new Order(orderId, user, items);
    }

    @Override
    public void addOrder(Order order) {
        Long orderId = nextId();
        order.getItems().forEach(item -> {
            OrderEntity orderEntity = new OrderEntity(orderId, order.getUser().getUserId(), item.getItemId());
            orderMapper.insertBatch(orderEntity);
        });
    }
}
