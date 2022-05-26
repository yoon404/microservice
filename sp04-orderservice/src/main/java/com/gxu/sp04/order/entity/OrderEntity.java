package com.gxu.sp04.order.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单表
 *
 * @author caoyuyi
 * @version 1.0
 * @date 2022/5/22 13:34:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("order")
public class OrderEntity {
    private Long orderId;
    private Integer userId;
    private Integer itemId;
}
