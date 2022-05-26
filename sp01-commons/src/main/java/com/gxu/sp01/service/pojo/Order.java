package com.gxu.sp01.service.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Administrator
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("order")
public class Order {
    private Long orderId;
    private User user;
    private List<Item> items;
}
