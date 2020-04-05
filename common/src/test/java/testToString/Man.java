package testToString;

import lombok.ToString;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author : _xu_
 * @desc : TODO
 * @date : 2020/3/27
 */
@ToString(callSuper = true,exclude = "card")
public class Man extends People{

    private  int card;
    private BigDecimal money;

    @Test
    public void fun01(){
        Man man = new Man();
        System.out.println(man);


    }
}
