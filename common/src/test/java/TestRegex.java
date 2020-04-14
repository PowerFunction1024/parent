import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : _xu_
 * @desc : 测试正则表达式
 * @date : 2020/3/22
 */
public class TestRegex {
    @Test
    public void fun01(){
        String regex = "\\?|\\*";  //返回\?|\*
        String regex1= "([]_%\\[\\\\])";  //([]_%\[\\])
        Pattern pattern = Pattern.compile(regex1);
        //返回正则表达式的字符串形式,其实就是返回Pattern.complile(String regex)的regex参数
        String patternStr = pattern.pattern();
        System.out.println(patternStr);
    }

    @Test
    public void fun02(){
        String str1="([]_%\\[\\\\])";
        String str2="\\\\$1";
        String input ="12[az12\\\\";
        //返回正则表达式的字符串形式,其实就是返回Pattern.complile(String regex)的regex参数
        Pattern compile = Pattern.compile(str1);
        //对指定输入的字符串创建一个Matcher对象
        Matcher matcher = compile.matcher(input);
        //使用Match实例获得信息，进行其他的操作
        String result = matcher.replaceAll(str2);
        System.out.println(result);
    }
}
