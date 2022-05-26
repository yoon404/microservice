package com.gxu.sp03.user.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gxu.sp01.service.UserService;
import com.gxu.sp01.service.pojo.User;
import com.gxu.web.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * 功能描述
 *
 * @author caoyuyi
 * @version 1.0
 * @date 2022/5/22 14:14:43
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Value("${server.port}")
    private int port;

    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    public JsonResult<?> getUser(@RequestBody User user) {
        log.info("server.port=" + port + ", user=" + user);
        JsonResult<?> res = userService.getUser(user);
        return JsonResult.ok(res);
    }

    @RequestMapping(value = "/addScore", method = RequestMethod.POST)
    public JsonResult addScore(@RequestParam Integer id, @RequestParam Integer score) {
        userService.addScore(id, score);
        return JsonResult.ok();
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public JsonResult addUser(@RequestBody User user) {
        userService.addUser(user);
        return JsonResult.ok();
    }

    @RequestMapping(value = "/findPage", method = RequestMethod.GET)
    public JsonResult findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                               @RequestParam(defaultValue = "10") Integer pageSize,
                               @RequestParam(defaultValue = "") String search) {
        Page<User> page = userService.findPage(pageNum, pageSize, search);
        return JsonResult.ok(page);
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public JsonResult updateUser(@RequestBody User user) {
        int i = userService.updateUser(user);
        return JsonResult.ok(i);
    }

    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
    public JsonResult deleteUser(@PathVariable Integer id) {
        int i = userService.deleteUser(id);
        return JsonResult.ok(i);
    }
}
