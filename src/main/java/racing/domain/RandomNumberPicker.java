package racing.domain;

import java.util.Random;
import racing.domain.race.NumberPicker;

public class RandomNumberPicker implements NumberPicker {
    public static final int BOUND = 10;

    @Override
    public int pickNumber() {
        Random random = new Random();
        return random.nextInt(BOUND);
    }
}
