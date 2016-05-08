package staticTest;

/**
 * Created by liuweimin on 16/4/29.
 */
public class Son extends Super {
    static String greeting() {
        return "Hello";
    }

    String name() {
        return "刘为民";
    }

    public static void main(String args[]) {
        Super s = new Son();
        System.out.println(s.greeting() + "," + s.name());
        System.out.println(s.greeting());
    }
}
