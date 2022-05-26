package com.gxu.sp02.item.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gxu.sp01.service.pojo.Item;
import com.gxu.sp02.item.entity.ItemEntity;
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
public interface ItemMapper extends BaseMapper<ItemEntity> {
    /**
     * 选择商品
     * @author caoyuyi
     * @date 2022/5/25 10:23
     * @param orderId
     * @return java.util.List<com.gxu.sp01.service.pojo.Item>
     */
    List<Item> selectItemByOrderId(Long orderId);
}
