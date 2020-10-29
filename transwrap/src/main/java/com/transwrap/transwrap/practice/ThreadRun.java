package com.transwrap.transwrap.practice;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadRun {
    private final ExecutorService executors = Executors.newFixedThreadPool(20);
    static int num = 0;

    public void test() {
        System.out.println("num : " + num++);
    }

    //线程池测试
    public void execute() {
        executors.submit(new Runnable() {
            @Override
            public void run() {
                test();
            }
        });
    }

    public static String dd() {
        return "hello";
    }

    //option测试
    public static String option_test(String object) {
        return Optional.ofNullable(object).orElseGet(() -> dd());
    }

    //测试不定长参数
    public static void pr(String... str) {
        for (String te : str) {
            System.out.println(te);
        }
    }

    List<Future<Integer>> result = new ArrayList<>();

    AtomicBoolean flag = new AtomicBoolean(true);

    // Future 与 Callable
    public void testFutureAndCallable(Callable<Integer> work) {
        result.add(executors.submit(work));
    }

    public void dealTheFuture() throws ExecutionException, InterruptedException {
        for (Future<Integer> future : result) {
            if (future.isDone()) {
                System.out.println("future.get() = " + future.get());
            } else {
                future.cancel(true);
            }
        }
    }

    static int resssult = 0;

    class work implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            for (int i = 0; i < (new Random()).nextInt(); ++i)
                resssult++;
            return resssult;
        }

    }

    void testThreadExectorInOrder() throws ExecutionException, InterruptedException {
        ResultExector<Integer> resultExector = new ResultExector<>();
        for(int i: new int[]{1, 2, 3}){
            resultExector.add(new work());
        }

        for(Future<Integer> future:resultExector.getBlockingQueue()){
            future.get();
        }
    }




}


@Data
final class ResultExector<T> {
    private final ExecutorService executorService = Executors.newFixedThreadPool(4);
    private BlockingQueue<Future<T>> blockingQueue = new LinkedBlockingDeque<>();

    public void add(Callable<T> t) {
        blockingQueue.add(executorService.submit(t));
    }

    public Future<T> take() throws ExecutionException, InterruptedException {
        return blockingQueue.take();
    }


}
