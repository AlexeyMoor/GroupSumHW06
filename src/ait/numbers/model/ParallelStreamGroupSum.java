package ait.numbers.model;

import java.util.Arrays;

public class ParallelStreamGroupSum extends GroupSum {
    public ParallelStreamGroupSum(int[][] numberGroup) {
        super(numberGroup);
    }

    @Override
    public int computeSum() {
        // TODO Homework advanced: compute the sum of all numbers in each group using parallel streams
        return Arrays.stream(numberGroup)
                .parallel()
                .mapToInt(arr -> Arrays.stream(arr).sum())
                .sum();
    }
}
