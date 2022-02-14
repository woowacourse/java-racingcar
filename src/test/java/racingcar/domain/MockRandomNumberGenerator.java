package racingcar.domain;

import racingcar.domain.game.RandomNumberGenerator;

public class MockRandomNumberGenerator implements RandomNumberGenerator {

    private static final int FORWARDING_NUMBER = 4;
    private static final int STOPPING_NUMBER = 0;
    private static final int[] RANDOM_NUMBERS = {
        FORWARDING_NUMBER, STOPPING_NUMBER,
        FORWARDING_NUMBER, STOPPING_NUMBER,
        STOPPING_NUMBER, FORWARDING_NUMBER,
        STOPPING_NUMBER, FORWARDING_NUMBER
    };
    private int index = 0;

    @Override
    public int getRandomNumber() {
        return RANDOM_NUMBERS[index++];
    }
}
