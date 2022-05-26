package com.gxu.sp01.service;

import com.gxu.sp01.service.pojo.Order;

/**
 * 订单接口
 *
 * @author caoyuyi
 * @version 1.0
 * @date 2022/5/22 12:04:49
 */
public interface OrderService {
    /**
     * 功能描述
     * @author caoyuyi
     * @date 2022/5/22 12:05
     * @param orderId
     * @return com.gxu.sp01.pojo.Order
     */
    Order getOrder(Long orderId);

    /**
     * 功能描述
     * @author caoyuyi
     * @date 2022/5/22 12:05
     * @param order
     * @return void
     */
    void addOrder(Order order);
}
