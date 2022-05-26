package com.gxu.sp04.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gxu.sp01.service.pojo.Item;
import com.gxu.sp01.service.pojo.User;
import com.gxu.sp04.order.entity.OrderEntity;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * 功能描述
 *
 * @author caoyuyi
 * @version 1.0
 * @date 2022/5/22 13:33:57
 */
@Component
public interface OrderMapper extends BaseMapper<OrderEntity> {
    void insertBatch(OrderEntity order);

    List<OrderEntity> selectByOrderId(Integer orderId);

    List<Item> selectItemByOrderId(Long orderId);

    User selectUserByOrderId(Long orderId);
}
