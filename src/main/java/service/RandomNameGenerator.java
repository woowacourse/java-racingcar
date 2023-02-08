package service;

public class RandomNameGenerator {

    public static int generateRandomNumber(int startInclusive, int endInclusive) {
        return (int) (Math.random() * 9);
    }
}
