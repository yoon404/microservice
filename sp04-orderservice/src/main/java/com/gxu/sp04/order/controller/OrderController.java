package com.gxu.sp04.order.controller;

import com.gxu.sp01.service.OrderService;
import com.gxu.sp01.service.pojo.Order;
import com.gxu.web.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 功能描述
 *
 * @author caoyuyi
 * @version 1.0
 * @date 2022/5/22 17:54:51
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/getOrder", method = RequestMethod.POST)
    public JsonResult<Order> getOrder(@RequestParam Long orderId) {
        log.info("get order, id=" + orderId);

        Order order = orderService.getOrder(orderId);
        return JsonResult.ok(order);
    }

    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
    public JsonResult addOrder(@RequestBody Order order) {
        //模拟post提交的数据
        orderService.addOrder(order);
        return JsonResult.ok();
    }

}
