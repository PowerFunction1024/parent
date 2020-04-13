import com.jadd.Application;
import com.jadd.been.dept;
import com.jadd.dao.DeptRepository;
import org.bson.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * @author : _xu_
 * @desc : 测试SpringDataMongoDB的基本CRUD
 * @date : 2020/2/3
 */
@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class test02 {

    @Autowired
    private DeptRepository deptRepository;
    @Autowired
    private MongoTemplate  mongoTemplate;
    @Test
    public void fun01(){
        List<dept> list = deptRepository.findAll();
        System.out.println("------------------");
        System.out.println(list);
    }
    @Test
    public void fun02(){
        dept dept = new dept().set_id("1123").setDeptno(20).setDname("小明").setLoc("深圳");
        System.out.println("------------------");
    }
    @Test
    public void fun03(){
        //第1个参数是页数，从0开始。第2个参数为每页条数
        PageRequest page = PageRequest.of(1, 2);
        Page<dept> depts = deptRepository.findAll(page);
        System.out.println("总页数：" + depts.getTotalPages());
        System.out.println("总记录数：" + depts.getTotalElements());
        System.out.println("查询结果：" + depts.getContent());
        //当前页数从0开始
        System.out.println("当前页数：" + depts.getNumber() +1);
        System.out.println("当前记录数：" + depts.getNumberOfElements());
        System.out.println("每页记录数：" + depts.getSize());
        System.out.println("------------------");
    }

    /**
     * @author _xu_
     * @Date 2020/2/4        
     * @Description 下面为MongoTemplate的测试
     * @param         
     * @return 
     */
    @Test
    public void fun04(){
        Query query = new Query(where("_id").is("1123"));
        List<dept> depts = mongoTemplate.find(query, dept.class);
        System.out.println(depts);
    }

    @Test
    public void fun05(){
        Query query = new Query();
        query.addCriteria(where("_id").is("1123"));
        List<dept> depts = mongoTemplate.find(query, dept.class);
        System.out.println(depts);
    }
    @Test
    public void fun06(){
        Query query = new Query();
        query.addCriteria(where("_id").is("11235"));

        Update update = new Update();
        update.set("loc","深圳06" ).set("deptno",60 );

        // updateMulti 更新查询返回结果集的全部
        //mongoTemplate.updateMulti(query, update,"dept");

        // upsert 更新对象不存在则去添加
        mongoTemplate.upsert(query,update ,"dept" );
    }

    @Test
    public void fun07(){
        dept dept = new dept().set_id("test").setLoc("test保存");
        //添加到test_save文档 ,没有的话则新增
        //mongoTemplate.save(dept,"test_save");
        mongoTemplate.save(dept,"dept");
    }

    @Test
    public void fun08(){
        //根据多个条件来查找删除
        Query query = new Query(where("loc").is("test保存"));
        query.addCriteria(where("_id").is("test"));
        mongoTemplate.remove(query,dept.class );

    /*
        dept dept = new dept().set_id("test").setLoc("test保存");
        //传入一个对象是根据ID 来删除
        mongoTemplate.remove(dept);*/

    }

    @Test
    public void fun09(){

        Query query = query(where("_id").is("test"));
        Update update = Update.update("title", "MongoTemplate").set("money", 100);
        //dept.class这里也可以写集合的名字,,这里写了 类名.class  主要是 类上有注解@Document(collection = "dept")
        mongoTemplate.updateMulti(query, update, dept.class);

    }
    @Test
    public void fun010(){

        Query query = query(where("_id").is("5941f2bac1bc86928f4de49b11")).addCriteria(where("dname").is("办公室"));
        Document queryObject = query.getQueryObject();
        Update update = Update.update("title", "MongoTemplate").set("money1", 101);
        mongoTemplate.updateMulti(query, update, dept.class);

    }
    @Test
    public void fun010_1(){

        Query query = query(where("_id").is("5941f2bac1bc86928f4de49b11")).addCriteria(where("dname").is("办公室"));
        Document queryObject = query.getQueryObject();
        Update update = Update.update("title", "MongoTemplate").set("money1", 101);
        mongoTemplate.upsert(query, update, dept.class);

    }
    //获取到查询条件
    @Test
    public void fun011(){
        Query query = query(where("_id").is("5941f2bac1bc86928f4de49b")).addCriteria(where("dname").is("办公室"));
        Criteria criteria = where("_id").is("5941f2bac1bc86928f4de49b").and("dname").is("办公室");
        Document criteriaObject = criteria.getCriteriaObject();
        //获取对应查询对象的查询条件   Document{{_id=5941f2bac1bc86928f4de49b, dname=办公室}}
        System.out.println(criteriaObject);
        System.out.println("=================");
        //获取对应查询对象的查询条件    Document{{_id=5941f2bac1bc86928f4de49b, dname=办公室}}
        Document queryObject = query.getQueryObject();
        System.out.println(queryObject);
        Update update = Update.update("title", "MongoTemplate").set("money", 101);
        mongoTemplate.updateMulti(query, update, dept.class);

    }



}














