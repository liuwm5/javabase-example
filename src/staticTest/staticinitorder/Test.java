package staticTest.staticinitorder;

/**
 * Created by liuweimin on 16/5/26.
 */
public class Test {
    static {
        System.out.println("test static 1");
    }
    /**
     * static块可以出现类中的任何地方（只要不是方法内部，记住，任何方法内部都不行），并且执行是按照static块的顺序执行的。
     */
    public static void main(String args[]) {

    }

    static {
        System.out.println("test static 2");
    }
}
