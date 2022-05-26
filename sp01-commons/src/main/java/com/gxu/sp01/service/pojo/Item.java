package com.gxu.sp01.service.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Administrator
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("item")
public class Item {
    @TableId(value="item_id",type= IdType.AUTO)
    private Integer itemId;
    private String name;
    private Integer number;

    public Item(Integer itemId){
        this.itemId= itemId;
    }
}