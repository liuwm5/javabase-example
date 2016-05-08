package classloadertest;

/**
 * Created by liuweimin on 16/4/30.
 */
public class SubClass extends  SuperClass {
    static {
        System.out.println("SubCLASS init!");
    }
}
