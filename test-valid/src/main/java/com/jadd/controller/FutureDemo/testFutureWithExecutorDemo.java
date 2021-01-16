package com.jadd.controller.FutureDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author : _xu_
 * @desc : TODO
 * @date : 2020/10/5
 */
public class testFutureWithExecutorDemo {




    public void dealListWithMutiThread(){
        List<Object> list = new ArrayList(10000);
        int index =0;
        ExecutorService ex = Executors.newFixedThreadPool(5);
        int dealSize = 2000;
        List<Future<List<Object>>> futures = new ArrayList<>(5);

    //    分配
        for (int i = 0; i < 5; i++,index+=dealSize) {
            int start =index ;
            if (start>=list.size()) break;
            int end =start+dealSize;
            end =end >list.size() ? list.size() :end;
            Future<List<Object>> future = ex.submit(new Task(list, start, end));
            futures.add(future);
        }
        try {
            //处理
            List<Object> result = new ArrayList();
            for (Future<List<Object>> future : futures) {
                //合并操作
                result.addAll(future.get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace( );
        }


    }

}
