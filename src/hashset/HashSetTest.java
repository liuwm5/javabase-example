package hashset;

import junit.framework.TestCase;

import java.util.HashSet;

/**
 * Created by liuweimin on 16/4/28.
 */
public class HashSetTest extends TestCase{
    public void testHashset(){
        HashSet<String> set = new HashSet<String>();
        set.add("1");
        set.add("2");
        set.add("3");
    }


}
