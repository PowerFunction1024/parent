package com.jadd.been;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
//@EqualsAndHashCode(callSuper = true)
@TableName("user")

public class User extends Model<User> {
    @TableId
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private Long managerId;
    private Date createTime;

}
