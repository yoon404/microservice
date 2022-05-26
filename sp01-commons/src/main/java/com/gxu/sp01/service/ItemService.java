package com.gxu.sp01.service;


import com.gxu.sp01.service.pojo.Item;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品接口
 *
 * @author caoyuyi
 * @version 1.0
 * @date 2022/5/22 12:02:18
 */
@Service
public interface ItemService {
    /**
     * 根据订单获取获取商品
     * @author caoyuyi
     * @date 2022/5/22 12:00
     * @param orderId
     * @return java.util.List<com.gxu.sp01.pojo.Item>
     */
    List<Item> getItems(Long orderId);

    /**
     * 更新商品
     * @author caoyuyi
     * @date 2022/5/22 12:00
     * @param list
     * @return void
     */
    void updateItems(List<Item> list);
}
