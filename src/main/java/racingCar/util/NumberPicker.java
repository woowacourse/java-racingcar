package racingCar.util;

public class NumberPicker {

    public int pickNumberInRange(int start, int end) {
        return (int)(Math.random() * (end - start)) + start;
    }
}
