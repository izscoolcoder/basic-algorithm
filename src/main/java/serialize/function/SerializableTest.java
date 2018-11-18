package serialize.function;

import serialize.dto.User;

import java.io.*;

/**
 * @author zhushuai
 */
public class SerializableTest {

    public static void main(String[] args) throws Exception {
        serializeUser();
        User user = deserializeUser();
        System.out.println(user.toString());

    }

    /**
     * 序列化
     */
    private static void serializeUser() throws IOException {
        User user = new User();
        user.setColor("black");
        user.setName("naruto");
        user.setCar("0000");
        // ObjectOutputStream 对象输出流，将 flyPig 对象存储到E盘的 flyPig.txt 文件中，完成对 flyPig 对象的序列化操作
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("d:/user.txt")));
        oos.writeObject(user);
        System.out.println("User 对象序列化成功！");
        oos.close();
    }

    /**
     * 反序列化
     */
    private static User deserializeUser() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("d:/user.txt")));
        User person = (User) ois.readObject();
        System.out.println("User 对象反序列化成功！");
        return person;
    }

}
