package ait.numbers.model;

import ait.numbers.task.OneGroupSum;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorGroupSum extends GroupSum {
    public ExecutorGroupSum(int[][] numberGroup) {
        super(numberGroup);
    }

    @Override
    public int computeSum() throws InterruptedException {
        // TODO Homework: compute the sum of all numbers in each group using thread pool (ExecutorService)
        int cpuCores = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(cpuCores);

        List<OneGroupSum> tasks = new ArrayList<>();
        for (int[] group : numberGroup) {
            tasks.add(new OneGroupSum(group));
        }

        for (OneGroupSum task : tasks) {
            executor.execute(task); // передача задачи в пул потоков
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        int totalSum = 0;
        for (OneGroupSum task : tasks) {
            totalSum += task.getSum();
        }
        return totalSum;
    }
}