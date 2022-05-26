package com.gxu.sp03.user.service;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gxu.sp01.service.UserService;
import com.gxu.sp01.service.pojo.User;
import com.gxu.sp03.user.entity.UserEntity;
import com.gxu.sp03.user.mapper.UserMapper;
import com.gxu.sp03.user.mapper.UserPageMapper;
import com.gxu.web.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 功能描述
 *
 * @author caoyuyi
 * @version 1.0
 * @date 2022/5/22 12:44:45
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserPageMapper userPageMapper;

    @Override
    public JsonResult<?> getUser(User user) {
        User res = userPageMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getName, user.getName()).eq(User::getPassword, user.getPassword()));
        if (res == null) {
            return JsonResult.err("用户名或密码错误");
        }
        return JsonResult.ok(res);
    }

    @Override
    public void addScore(Integer id, Integer score) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id", id);
        UserEntity userEntity = userMapper.selectById(id);
        userEntity.setScore(userEntity.getScore() + score);

        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.eq("user_id", id);
        userMapper.update(userEntity, updateWrapper);
    }


    @Override
    public void addUser(User user) {
        if (user.getPassword() == null) {
            user.setPassword("123456");
        }
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        userMapper.insert(userEntity);
    }

    @Override
    public Page<User> findPage(Integer pageNum, Integer pageSize, String search) {
        LambdaQueryWrapper<User> wrapper = Wrappers.<User>lambdaQuery();
        if (StrUtil.isNotBlank(search)) {
            wrapper.like(User::getNickName, search);
        }
        return userPageMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
    }

    @Override
    public int updateUser(User user) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        return userMapper.updateById(userEntity);
    }

    @Override
    public int deleteUser(Integer id) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id", id);
        userMapper.deleteOrderByUserId(id);
        return userMapper.delete(queryWrapper);
    }
}
