package com.gxu.sp03.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gxu.sp03.user.entity.UserEntity;
import org.springframework.stereotype.Component;


/**
 * 功能描述
 *
 * @author caoyuyi
 * @version 1.0
 * @date 2022/5/22 13:33:57
 */
@Component
public interface UserMapper extends BaseMapper<UserEntity> {
    /**
     * 删除订单
     * @author caoyuyi
     * @date 2022/5/25 10:24
     * @param userId
     * @return void
     */
    void deleteOrderByUserId(Integer userId);
}
