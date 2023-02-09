package racingCar.util;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public int pickOneNumberInRange(int start, int end) {
        return (int)(Math.random() * (end - start)) + start;
    }
}
