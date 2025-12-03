package ait.numbers.model;

public abstract class GroupSum {
    protected int[][] numberGroup;

    public GroupSum(int[][] numberGroup) {
        this.numberGroup = numberGroup;
    }

    public abstract int computeSum() throws InterruptedException;
}
