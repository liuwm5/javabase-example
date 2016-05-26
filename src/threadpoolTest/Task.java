package threadpoolTest;

/**
 * Created by liuweimin on 16/5/21.
 */
public class Task implements Runnable {
    private int count;
    @Override
    public void run() {
        System.out.println(count);
        try {
            Thread.sleep(150);
        }catch (Exception e){
        }
    }
    public Task(int count){
        this.count=count;
    }
}
