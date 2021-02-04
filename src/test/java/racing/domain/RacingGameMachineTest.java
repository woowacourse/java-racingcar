package racing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class RacingGameMachineTest {

    @Test
    void Machine_tryCounts가_줄어든다() {
        int tryCounts = 1;
        RacingGameMachine racingGameMachine = new RacingGameMachine(tryCounts);
        racingGameMachine.play();
        assertThat(racingGameMachine.canPlay()).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void Machine_시도횟수가_양수가_아니면_에러가_발생한다(int tryCounts) {
        assertThatThrownBy(() -> new RacingGameMachine(tryCounts))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static class RacingGameMachine {
        private static final int ZERO = 0;

        private int tryCounts;

        RacingGameMachine(int tryCounts) {
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
        }

        public boolean canPlay() {
            return tryCounts > ZERO;
        }
    }
}