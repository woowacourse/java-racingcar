package racingcar;

import racingcar.utils.RandomNumberGenerator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacingCarTest {

    private static final int FIRST_TRYING = 0;
    private static final int LAST_TRYING = 100;
    private static final int DOWN_LIMIT = 0;
    private static final int UP_LIMIT = 9;

    @Test
    void randomNumberGenerator() {
        for(int i = FIRST_TRYING; i <LAST_TRYING ; i++) {
            int value = RandomNumberGenerator.turnNumber();

            assertTrue(value <= UP_LIMIT);
            assertTrue(value >= DOWN_LIMIT);
        }
    }


}
