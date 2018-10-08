package collection;

import com.google.common.collect.Lists;
import org.apache.logging.log4j.core.util.JsonUtils;
import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author zhushuai
 */
public class IteratorTest {


    @Test
    public void test1() {
        List<String> students = Lists.newArrayList("cool", "sweet");
        Iterator<String> stringIterator = students.iterator();
        while (stringIterator.hasNext()) {
            System.out.println(stringIterator.next());
        }
        //stringIterator 下表不断下移
        while (stringIterator.hasNext()) {
            System.out.println(stringIterator.next());
        }
        //next 返回的是上一个引用的值  下标下移
        System.out.println(stringIterator.next());
    }


    @Test
    public void test2() {
        List<String> students = Lists.newArrayList("cool", "sweet");
        Iterator<String> stringIterator = students.iterator();
        //remove方法一定是在 next 之后
        stringIterator.next();
        stringIterator.remove();
        //remove 方法一定是 next成对出现  否则报错 IllegalStateException
        stringIterator.remove();
    }

    @Test
    public void test3() {
        List<String> a = new LinkedList<>();

        a.add("Amy");
        a.add("Carl");
        a.add("Erica");

        List<String> b = new LinkedList<>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Gloria");

        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.listIterator();

        while (bIter.hasNext()) {
            if (aIter.hasNext()) {
                aIter.next();
            }
            aIter.add(bIter.next());
        }

        System.out.println(a);

        bIter = b.iterator();
        while (bIter.hasNext()) {
            bIter.next();
            if (bIter.hasNext()) {
                bIter.next();
                bIter.remove();
            }
        }
        System.out.println(b);

        a.removeAll(b);

        System.out.println(a);

    }

    /**
     * 针对subList 只是视图 对于视图的增加修改 会影响到元数据列表
     */
    @Test
    public void test4() {
        List<String> origin = Lists.newArrayList("w", "s", "g", "j", "k", "l");
        List<String> subList = origin.subList(1, 3);
        System.out.println(origin.toString());
        System.out.println(subList.toString());

        subList.add("wo");
        subList.add("kk");
        System.out.println(origin.toString());
        System.out.println(subList.toString());

        //这个时候再次操作原数据列表即会报错 java.util.ConcurrentModificationException
        origin.remove(1);
        origin.remove(5);
        System.out.println(origin.toString());
        System.out.println(subList.toString());
    }

}
