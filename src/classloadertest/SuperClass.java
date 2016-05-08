package classloadertest;

/**
 * Created by liuweimin on 16/4/30.
 */
public class SuperClass {
    static {
        System.out.println("SuperClass init!");
    }
    public  static  int value=123;
}
