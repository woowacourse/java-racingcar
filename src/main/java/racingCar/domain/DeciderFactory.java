package racingCar.domain;

import java.util.Random;

public class DeciderFactory {
    private static final int ONE_FOR_RANDOM = 1;
    private static final Random RANDOM = new Random();

    private DeciderFactory() {
    }

    public static Decider createRandomDecider() {
        return new Decider(getRandomFromZeroToNine());
    }

    private static int getRandomFromZeroToNine() {
        return RANDOM.nextInt(Decider.MAX + ONE_FOR_RANDOM);
    }

}
