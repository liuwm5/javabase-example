package threadpoolTest;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by liuweimin on 16/5/21.
 */
public class Controller {

    public static void main(String args[]) {
        //默认最大为Int 的最大值
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,
                10,
                1000,
                TimeUnit.HOURS,
                queue);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 15000; i++) {
            executor.execute(new Task(i));
            int threadSize = queue.size();
            System.out.println("线程队列大小为-->" + threadSize);
        }
        System.out.println("耗费时间为：" + (System.currentTimeMillis() - startTime));
        executor.shutdown();
        System.out.println("耗费时间为：" + (System.currentTimeMillis() - startTime));

    }

}
