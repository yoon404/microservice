package com.gxu.sp02.item.controller;

import com.gxu.sp01.service.ItemService;
import com.gxu.sp01.service.pojo.Item;
import com.gxu.web.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 功能描述
 *
 * @author caoyuyi
 * @version 1.0
 * @date 2022/5/22 14:14:43
 */
@Slf4j
@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;


    @Value("${server.port}")
    private int port;

    @RequestMapping(value = "/getItem", method = RequestMethod.GET)
    public JsonResult<List<Item>> getItems(@RequestParam Long orderId) {
        log.info("server.port=" + port + ", orderId=" + orderId);

        List<Item> items = itemService.getItems(orderId);
        return JsonResult.ok(items).msg("port=" + port);
    }

    @RequestMapping(value = "/updateItems", method = RequestMethod.POST)
    public JsonResult updateItems(@RequestBody List<Item> items) {
        itemService.updateItems(items);
        return JsonResult.ok();
    }
}
