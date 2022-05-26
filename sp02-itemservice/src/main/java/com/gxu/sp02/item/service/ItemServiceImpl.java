package com.gxu.sp02.item.service;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.gxu.sp01.service.ItemService;
import com.gxu.sp01.service.pojo.Item;
import com.gxu.sp02.item.entity.ItemEntity;
import com.gxu.sp02.item.mapper.ItemMapper;
import com.gxu.web.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能描述
 *
 * @author caoyuyi
 * @version 1.0
 * @date 2022/5/22 12:44:45
 */
@Slf4j
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemMapper itemMapper;

    @Override
    public List<Item> getItems(Long orderId) {
        List<Item> list = itemMapper.selectItemByOrderId(orderId);
        JsonResult.ok(list).msg("根据订单id查找商品成功");
        return list;
    }


    @Override
    public void updateItems(List<Item> list) {
        list.stream().forEach(item -> {
            UpdateWrapper updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("item_id",item.getItemId());
            ItemEntity itemEntity = new ItemEntity();
            BeanUtils.copyProperties(item,itemEntity);
            itemMapper.update(itemEntity,updateWrapper);

        });
    }
}
