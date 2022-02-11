package racingcar.domain;

import racingcar.domain.random.RandomNumberGenerator;

public class MockRandomNumberGenerator implements RandomNumberGenerator {

    static final int FORWARDING_NUMBER = 4;
    static final int STOPPING_NUMBER = 0;
    static final int[] RANDOM_NUMBERS = {
        FORWARDING_NUMBER, STOPPING_NUMBER,
        FORWARDING_NUMBER, STOPPING_NUMBER,
        STOPPING_NUMBER, FORWARDING_NUMBER,
        STOPPING_NUMBER, FORWARDING_NUMBER
    };
    int index = 0;

    @Override
    public int getRandomNumber() {
        return RANDOM_NUMBERS[index++];
    }
}
