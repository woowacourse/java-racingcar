package racingCar.util;

public class NumberPicker {

    public static int pickNumberInRange(int start, int end) {
        return (int)(Math.random() * (end - start)) + start;
    }
}
