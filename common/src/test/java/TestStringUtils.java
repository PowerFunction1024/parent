import org.junit.Test;
import org.springframework.util.StringUtils;

/**
 * @author : _xu_
 * @desc : TODO
 * @date : 2020/3/26
 */
public class TestStringUtils {
    @Test
    public void fun01(){
        String s="";
        System.out.println(StringUtils.isEmpty(s));
    }

    @Test
    public void fun02(){
        String v="中";
        byte[] bytes = v.getBytes();
        System.out.println(org.assertj.core.util.Arrays.asList(bytes));


    }
}
