package racingCar.domain;

import java.util.Random;

public class RandomDeciderFactory implements DeciderFactory {
    private static final int ONE_FOR_RANDOM = 1;
    private static final Random RANDOM = new Random();

    @Override
    public Decider create() {
        return new Decider(getRandomFromZeroToNine());
    }

    private int getRandomFromZeroToNine() {
        return RANDOM.nextInt(Decider.MAX + ONE_FOR_RANDOM);
    }

}
