package domain;

import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.powerGenerator.PowerGenerator;

class RacingGameTest {
    @DisplayName("우승자 테스트")
    @Test
    void getWinnersTest() {
        int[] powers = {3, 3, 4, 3, 3, 4, 3, 3, 4};
        String[] carNames = "a,b,c".split(",");
        int tryCount = 3;
        PowerGenerator powerGenerator = new TestPowerGenerator(powers);
        RacingGame racingGame = new RacingGame(carNames, tryCount, powerGenerator);
        racingGame.start();
        Assertions.assertThat(racingGame.getWinners().stream()
                        .map(Car::getName).collect(Collectors.toList()))
                .containsExactly("c");
    }

    static class TestPowerGenerator implements PowerGenerator {
        final int[] powers;
        int index = 0;

        public TestPowerGenerator(int[] powers) {
            this.powers = powers;
        }

        @Override
        public int generate() {
            return powers[index++];
        }
    }
}
