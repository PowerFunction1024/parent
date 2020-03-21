import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

/**
 * @author : _xu_
 * @desc : TODO
 * @date : 2020/2/3
 */

/*
        1. mongodb-driver: mongo官方提供的一个Java操作Mongo客户端 类似jdbc驱动

        2. 如果有条件, 我们使用 new BasicDbObject()
        - 一个BasicDbObject就相当于语法里面的一个{}

        3. 我们使用mongodb-driver有些繁琐,
        项目里面使用Spring-Data-mongo, 内部就是封装了mongodb-driver
*/

public class test {

    private  MongoCollection<Document> dept;
    private  MongoClient mongoClient;
    @Before
    public void before(){
        //    创建连接
         mongoClient = new MongoClient("127.0.0.1");
        //    获取数据库
        MongoDatabase test = mongoClient.getDatabase("test");

        //    获取集合
         dept = test.getCollection("dept");

    }

    @After
    public void after(){

        //    关闭连接
        mongoClient.close();
    }



    @Test
    public void fun01(){
        //    通过api操作mongodb
        FindIterable<Document> documents = dept.find();
        System.out.println(
                "------------------------"
        );
        for (Document document : documents) {
            System.out.println("id:" + document.get("_id") +
                    "deptno:" + document.get("deptno") +
                    "dname:" + document.get("dname") +
                    "loc:" + document.get("loc")
            );
            System.out.println(
                    "------------------------"
            );
        }
    }
    @Test
    public void fun02(){
        //    通过api操作mongodb
        FindIterable<Document> documents = dept.find(new BasicDBObject("dname","财务部"));
        System.out.println(
                "------------------------"
        );
        for (Document document : documents) {
            System.out.println("id:" + document.get("_id") +
                    "deptno:" + document.get("deptno") +
                    "dname:" + document.get("dname") +
                    "loc:" + document.get("loc")
            );
            System.out.println(
                    "------------------------"
            );
        }
    }

    @Test
    public void fun03(){
        HashMap<String,Object> hm = new HashMap();
        hm.put("deptno",880 );
        hm.put("dname","测试部门" );
        hm.put("loc","普宁" );
        Document document = new Document(hm);
        dept.insertOne(document);
    }

    @Test
    public void fun04(){

        BasicDBObject filter = new BasicDBObject("dname", "测试部门");
        BasicDBObject set = new BasicDBObject("$set",new Document("dname","测试部门22"));

        UpdateResult updateResult = dept.updateOne(filter, set);
        System.out.println(updateResult);
    }
    @Test
    public void fun05(){


        BasicDBObject filter = new BasicDBObject("dname", "测试部门22");
        dept.deleteOne(filter);
    }
    @Test
    public void fun055555555(){


        BasicDBObject filter = new BasicDBObject("dname", "测试部门22");
        dept.deleteOne(filter);
    }
}
