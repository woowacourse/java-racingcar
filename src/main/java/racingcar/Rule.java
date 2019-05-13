package racingcar;

public class Rule {
    public static final int RANDOM_NUMBER_GENERATING_STANDARD = 10;

    public static int randomNumberGenerator() {
        return (int) (Math.random() * RANDOM_NUMBER_GENERATING_STANDARD);
    }


}
