package classloadertest;

import junit.framework.TestCase;

/**
 * Created by liuweimin on 16/4/30.
 * 对于静态字段，只有直接定义这个字段的类才会被初始化，
 * 因此通过其子类来引用父类中定义的静态字段，只会触发父类的初始化而不会触发子类的初始化。
 */
public class NotInitialization extends TestCase{
    public void testSubClass(){
        System.out.println(SubClass.value);
    }
    public void testArrayInit(){
        SuperClass[] sca=new SuperClass[10];
    }
}
