package com.jadd.been;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true)
//@EqualsAndHashCode(callSuper = true)
@TableName("user")

public class User implements Serializable{
    @TableId
    private long id;
    private String name;
    private int age;
    private String email;
    private long managerId;
    private Date createTime;

}
