package staticTest;

/**
 * Created by liuweimin on 16/5/25.
 */
public class Base {
    static{
        System.out.println("base static");
    }


    public Base(){
        System.out.println("base constructor");
    }
}
