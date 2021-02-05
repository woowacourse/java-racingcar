package racingcar.utils;

public class RandomNumber {
    private static int NUMBER_MIN = 0;
    private static int NUMBER_MAX = 9;

    public int generate() {
        return (int) (Math.random() * NUMBER_MAX + NUMBER_MIN);
    }
}
