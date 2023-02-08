package racingCar.util;

public class RandomNumberPicker implements NumberPicker {
    @Override
    public int pickOneNumber() {
        return (int)Math.random() * 10;
    }
}
