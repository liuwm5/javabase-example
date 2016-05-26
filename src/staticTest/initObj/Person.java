package staticTest.initObj;

/**
 * Created by liuweimin on 16/5/25.
 */
public class Person {
    static{
        System.out.println("person static");
    }
    public Person(String str) {
        System.out.println("person "+str);
    }
}
