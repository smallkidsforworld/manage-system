package functionalTest;

import org.springframework.util.DigestUtils;

/**
 * @author ：yml
 * @date ：Created in 2020/10/30 10:30
 * @description：用户登录测试
 * @modified By：
 */
public class LoginTest {
    public static void main(String[] args) {
        System.out.println("DigestUtils.md5DigestAsHex(\"178214yml\") = " + DigestUtils.md5DigestAsHex("178214yml".getBytes()));
    }
}
