package staticTest;

/**
 * Created by liuweimin on 16/5/25.
 */
public class Test  extends  Base{
    static{
        System.out.println("test static");
    }


    public Test(){
        System.out.println("test constructor");
    }


    public static void main(String[] args) {
        new Test();
        //1.先找到父类 ，加载父类的静态块。
        //2.加载完父类，转为加载子类,发现静态方法后，初始化静态块。
        //3.加载所需的类后，执行main方法
        //4.new Test() 时会先调用父类构造方法
        //5.再调用自身的构造器

    }
}
