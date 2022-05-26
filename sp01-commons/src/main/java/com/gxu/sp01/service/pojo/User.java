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
@TableName("user")
public class User {
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
