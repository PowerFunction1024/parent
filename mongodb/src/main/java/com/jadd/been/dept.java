package com.jadd.been;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @author : _xu_
 * @desc : TODO
 * @date : 2020/2/3
 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "dept") //collection表示集合名称，不写则默认为实体类名称
public class dept implements Serializable {
    @Id
    private String _id;
    private String loc;
    private String dname;
    private Integer deptno;
}
