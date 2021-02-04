package racing.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameMachineTest {
    private static final Cars DUMMY_CARS = Cars.generate("pobi,brown");

    @Test
    void Machine_tryCounts가_줄어든다() {
        int tryCounts = 1;
        RacingGameMachine racingGameMachine = new RacingGameMachine(DUMMY_CARS, tryCounts);
        racingGameMachine.play();
        assertThat(racingGameMachine.canPlay()).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void Machine_시도횟수가_양수가_아니면_에러가_발생한다(int tryCounts) {
        assertThatThrownBy(() -> new RacingGameMachine(DUMMY_CARS, tryCounts))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static class RacingGameMachine {
        private static final int ZERO = 0;

        private final Cars cars;
        private int tryCounts;

        RacingGameMachine(Cars cars, int tryCounts) {
            this.cars = cars;
            this.tryCounts = tryCounts;
            validateTryCounts();
        }

        private void validateTryCounts() {
            if (tryCounts <= ZERO) {
                throw new IllegalArgumentException();
            }
        }

        public void play() {
            tryCounts--;
            cars.race();
        }

        public boolean canPlay() {
            return tryCounts > ZERO;
        }
    }
}