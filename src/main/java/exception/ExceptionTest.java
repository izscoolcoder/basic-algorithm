package exception;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 这段代码的核心就是return 返回的值
 * <p>
 * finally 毫无疑问是在代码最后执行的。
 * return 的返回值最终会覆盖掉上一个return 返回的值
 * 针对返回的值 会临时存在栈中
 * 返回的如果是对象  则返回的是对这个对象的引用值
 * 所以user 对象即使不是new 出来的 只要从新set 值就会被update
 *
 * @author zhushuai
 * @date 2018/08/13
 */
public class ExceptionTest {


    public static void main(String[] args) {
        System.out.println(method());
        System.out.println(user().getUserId());
        System.out.println(nullPointer().getUserId());

        resource();
    }


    public static int method() {
        int x = 1;
        try {
            return x;
        } catch (Exception e) {
            return 0;
        } finally {
            ++x;
        }
    }

    public static User user() {
        User user = new User();
        try {
            user.setUserId(1);
            return user;
        } catch (Exception e) {

            return user;
        } finally {
            user = new User();
            user.setUserId(2);
            return user;
        }
    }

    /**
     * 针对当前方法测试的是 即使catch 代码块中有异常
     * finally 最终也会执行  但是代码finally 中有异常 则会抛出异常
     *
     * @return
     */
    public static User nullPointer() {
        User user = null;
        try {
            user.setUserId(1);
            return user;
        } catch (Exception e) {
            user.setUserId(2);
            return user;
        } finally {
            //通过注释下一行代码可以观察不同结果
            user = new User();
            user.setUserId(3);
            return user;
        }
    }

    /**
     *
     */
    public static void resource() {
        try (Scanner in = new Scanner(new FileInputStream("E://a.txt"))) {
            while (in.hasNext()) {
                System.out.println(in.next());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
