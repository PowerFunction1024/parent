package com.jadd.been;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @Excel(name = "id")
    @NotBlank(message = "该字段不能为空")
    private String id;

    @Excel(name = "姓名")
    @Pattern(regexp = "[\\u4E00-\\u9FA5]{2,5}", message = "姓名中文2-5位")
    private String name;

    @Max(value = 20)
    @Excel(name = "年龄")
    private Integer age;

    @Excel(name = "生日", importFormat = "yyyy-MM-dd")
    private Date birthday;

    public void setId(String id) {
        this.id = id;
    }
}
