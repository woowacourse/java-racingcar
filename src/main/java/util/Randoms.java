package util;

public class Randoms {
    private Randoms() {}

    public static int pickNumberInRange(int startExclusive, int endInclusive) {
        return (int) (Math.random() * (endInclusive - startExclusive + 1)) + startExclusive;
    }
}
