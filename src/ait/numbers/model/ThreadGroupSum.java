package ait.numbers.model;

import ait.numbers.task.OneGroupSum;

public class ThreadGroupSum extends GroupSum {
    public ThreadGroupSum(int[][] numberGroup) {
        super(numberGroup);
    }

    @Override
    public int computeSum() throws InterruptedException {
        // TODO Homework: compute the sum of all numbers in each group using threads
        Thread[] threads = new Thread[numberGroup.length];
        OneGroupSum[] tasks = new OneGroupSum[numberGroup.length];

        for (int i = 0; i < numberGroup.length; i++) {
            tasks[i] = new OneGroupSum(numberGroup[i]);
            threads[i] = new Thread(tasks[i]);
            threads[i].start();
        }

        for (int i = 0; i < numberGroup.length; i++) {
            threads[i].join();
        }

        int totalSum = 0;
        for (int i = 0; i < numberGroup.length; i++) {
            totalSum += tasks[i].getSum();
        }
        return totalSum;
    }
}
