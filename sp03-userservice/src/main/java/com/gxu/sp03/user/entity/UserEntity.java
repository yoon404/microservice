package com.gxu.sp03.user.entity;

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
@TableName("user")
public class UserEntity {
    @TableId(value="user_id",type= IdType.AUTO)
    private Integer userId;
    private String name;
    private String password;
    private int score;
    private String sex;
    private int age;
    private String nickName;
    private String address;
}
