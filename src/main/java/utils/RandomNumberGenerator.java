package utils;

public class RandomNumberGenerator {

    public static int generateRandomNumber() {
        return (int) (Math.random() * 9 + 1);
    }
}
