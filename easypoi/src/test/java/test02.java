import org.junit.Test;

import java.util.ArrayList;

/**
 * @author : _xu_
 * @desc : TODO
 * @date : 2020/1/20
 */
public class test02 {
    @Test
    public void fun01(){
        ArrayList<Integer> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList();
        ArrayList<Integer> a3 = new ArrayList();
        a1.add(45);
        a1.add(45);
        a2.add(78);
        a3.addAll(a1);
        a3.addAll(a2);
        System.out.println(a3);


    }
}
