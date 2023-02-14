package racingCar.util;

public class NumberPickerUtil {

    public static int pickNumberInRange(int start, int end) {
        return (int)(Math.random() * (end - start)) + start;
    }
}
