package domain;

public class RandomUtil {
    public static int randomNumber() {
        return (int) (Math.random() * Constant.RANDOM_NUMBER_RANGE);
    }
}
