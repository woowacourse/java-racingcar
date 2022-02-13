package racingcar.service.picker;

import java.util.Random;

public class RandomNumberPicker implements NumberPicker {

    private final Random random;

    public RandomNumberPicker() {
        random = new Random();
        random.setSeed(System.currentTimeMillis());
    }

    @Override
    public int pickNumber() {
        return random.nextInt(RandomRange.getSize()) + RandomRange.getInclusiveMinimum();
    }

}
