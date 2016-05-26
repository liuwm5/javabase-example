package staticTest.initObj;

/**
 * Created by liuweimin on 16/5/25.
 */
public class Test {
    Person person = new Person("Test");
    static{
        System.out.println("test static");
    }


    public Test() {
        System.out.println("test constructor");
    }

    /**
     * 1.首先加载Test类 因此执行Test类的 static 块
     * 2.执行 new MyClass（）从而触发 加载MyClass 类
     * 3.加载Myclass 发现继承自Test  Test已经加载过了，那么接下来加载Myclass时会加载静态块
     * 4.加载完成后，通过构造器生成对象，生成对象时，必须完成父类成员变量的初始化
     * 5.因此执行Test 类中的 Person
     * 6.Person 类还没有加载过，先加载Person类的静态块
     * 7.接着执行父类的构造器 完成父类初始化
     * 8.然后初始化自身，初始化自身成员变量
     * 9.最后执行MyClass的构造器
     * @param args
     */
    public static void main(String[] args) {
        new MyClass();
    }
}
