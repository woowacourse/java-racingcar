package racingcar;

public class Car {

    private static final int MIN_NUMBER = 4;
    private int position;

    public void go(final int number) {
        if (number >= MIN_NUMBER) {
            position++;
        }
    }
}
