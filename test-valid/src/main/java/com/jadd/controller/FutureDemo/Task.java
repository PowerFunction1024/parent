package com.jadd.controller.FutureDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author : _xu_
 * @desc : TODO
 * @date : 2020/10/5
 */
public class Task implements Callable<List<Object>>{

    private List<Object> list;
    private int start ;
    private int end ;

    public Task(List<Object> list, int start, int end) {
        this.list = list;
        this.start = start;
        this.end = end;
    }

    @Override
    public List<Object> call() throws Exception {
        Object obj=null;
        List<Object> resList = new ArrayList();
        for (int i= start; i<end ; i++){
            obj=list.get(i);
        //    业务处理逻辑
        }
        //返回处理的结果
        return resList;
    }
}
