package staticTest.initObj;

/**
 * Created by liuweimin on 16/5/25.
 */
public class MyClass extends Test {
    Person person = new Person("MyClass");

    static {
        System.out.println("myclass static");
    }


    public MyClass() {
        System.out.println("myclass constructor");
    }
}
