package com.jadd.been;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author : _xu_
 * @desc : TODO
 * @date : 2020/1/15
 */
@Data
@Accessors(chain = true)
public class User {
    private String id;

    private  String name;

    @NotNull(message = "密码不能为空")
    private String password;

    @DecimalMax(value = "10",message = "不能大于10")
    private BigDecimal price;

    @Future(message = "必须是一个将来的日期")
    private Date day;
}
