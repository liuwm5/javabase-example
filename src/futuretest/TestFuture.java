package futuretest;

import junit.framework.TestCase;

import java.util.concurrent.*;

/**
 * Created by liuweimin on 16/5/8.
 */
public class TestFuture extends TestCase {
    public void testCallAbleAndFuture() {
        ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();
        Future<Integer> result = executor.submit(task);
        executor.shutdown();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("主线程在执行任务");

        try {
            System.out.println("task运行结果" + result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("所有任务执行完毕");
    }

 public void testCallAbleAndFutureTask(){
     ExecutorService executorService = Executors.newCachedThreadPool();
     Task task = new Task();
     FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
     executorService.submit(futureTask);
     executorService.shutdown();

     try{
         Thread.sleep(1000);
     }catch (Exception e){
         e.printStackTrace();
     }
     System.out.println("主线程在执行任务");

     try {
         System.out.println("task运行结果："+futureTask.get());
     } catch (InterruptedException e) {
         e.printStackTrace();
     } catch (ExecutionException e) {
         e.printStackTrace();
     }
     System.out.println("所有任务执行完毕");
 }


}
