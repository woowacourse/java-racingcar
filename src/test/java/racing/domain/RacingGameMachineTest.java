package racing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RacingGameMachineTest {

    @Test
    void Machine_tryCounts가_줄어든다() {
        int tryCount = 1;
        RacingGameMachine racingGameMachine = new RacingGameMachine(tryCount);
        racingGameMachine.play();

        Assertions.assertThat(racingGameMachine.canPlay()).isFalse();
    }

    private static class RacingGameMachine {
        private int tryCounts;

        RacingGameMachine(int tryCounts) {
            this.tryCounts = tryCounts;
        }

        public void play() {
            tryCounts--;
        }

        public boolean canPlay() {
            return tryCounts > 0;
        }
    }
}