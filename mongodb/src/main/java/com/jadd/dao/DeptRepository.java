package com.jadd.dao;

import com.jadd.been.dept;
import org.springframework.data.mongodb.repository.MongoRepository;
/*
 * @author _xu_
 * @Date 2020/2/3        
 * @Description TODO
 * @param null
 * @return 
 */
public interface DeptRepository extends MongoRepository<dept,String> {

}