package domain;

import java.util.Random;

public class RandomNumber implements Number {
    private static Random random = new Random();
    private final int number;

    private RandomNumber(int number) {
        this.number = number;
    }

    public static RandomNumber of(int minRange, int maxRange) {
        int number = random.nextInt((maxRange - minRange) + 1) + minRange;
        return new RandomNumber(number);
    }

    @Override
    public int get() {
        return number;
    }
}
