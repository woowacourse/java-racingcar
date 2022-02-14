package racingcar;

import racingcar.domain.random.RandomNumberGenerator;

public class MockRandomNumberGenerator implements RandomNumberGenerator {

    private static final int FORWARD_BOUNDARY_NUMBER = 4;

    static final int NUMBER_FOR_FORWARD = 4;
    static final int NUMBER_FOR_STOP = 0;
    static final int[] MOCK_RANDOM_NUMBERS = {
            NUMBER_FOR_FORWARD, NUMBER_FOR_STOP,
            NUMBER_FOR_FORWARD, NUMBER_FOR_STOP,
            NUMBER_FOR_STOP, NUMBER_FOR_FORWARD,
            NUMBER_FOR_STOP, NUMBER_FOR_FORWARD
    };
    int index = 0;

    @Override
    public boolean isAvailableMove() {
        return MOCK_RANDOM_NUMBERS[index++] >= FORWARD_BOUNDARY_NUMBER;
    }
}
