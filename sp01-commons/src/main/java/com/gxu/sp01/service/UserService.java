package com.gxu.sp01.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gxu.sp01.service.pojo.User;
import com.gxu.web.util.JsonResult;
import org.springframework.stereotype.Service;

/**
 * 用户接口
 *
 * @author caoyuyi
 * @version 1.0
 * @date 2022/5/22 12:02:18
 */
@Service
public interface UserService {
    /**
     * 获取用户信息
     * @param user
     * @return com.gxu.sp01.pojo.User
     * @author caoyuyi
     * @date 2022/5/22 12:02
     */
    JsonResult<?> getUser(User user);

    /**
     * 增加用户积分
     * @param id
     * @param score
     * @author caoyuyi
     * @date 2022/5/22 12:02
     */
    void addScore(Integer id, Integer score);

    /**
     * 增加新用户
     * @author caoyuyi
     * @date 2022/5/24 16:37
     * @param user
     * @return void
     */
    void addUser(User user);

    /**
     * 分页查找
     * @author caoyuyi
     * @date 2022/5/24 17:16
     * @param pageNum
     * @param pageSize
     * @param search
     * @return void
     */
    Page<User> findPage(Integer pageNum, Integer pageSize, String search);

    /**
     * 更新用户
     * @author caoyuyi
     * @date 2022/5/24 20:25
     * @param user
     * @return void
     */
    int updateUser(User user);
    /**
     * 删除用户
     * @author caoyuyi
     * @date 2022/5/24 20:26
     * @param id
     * @return void
     */
    int deleteUser(Integer id);
}

