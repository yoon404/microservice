package com.gxu.sp02.item.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 商品表
 *
 * @author caoyuyi
 * @version 1.0
 * @date 2022/5/22 13:34:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("item")
public class ItemEntity {
    @TableId(value="item_id",type= IdType.AUTO)
    private Integer itemId;
    private String name;
    private Integer number;
}
