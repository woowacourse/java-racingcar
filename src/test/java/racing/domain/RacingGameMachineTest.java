package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameMachineTest {
    private static final Cars DUMMY_CARS = Cars.generate("pobi,brown", () -> true);

    @DisplayName("게임을 1회 진행하면 플레이 가능 횟수가 1회 차감된다.")
    @Test
    void decreaseTryCounts() {
        int tryCounts = 1;
        RacingGameMachine racingGameMachine = new RacingGameMachine(DUMMY_CARS, tryCounts);

        racingGameMachine.race();
        boolean isPlayable = racingGameMachine.canPlay();

        assertThat(isPlayable).isFalse();
    }

    @DisplayName("게임 시도 회수가 양수가 아니면 객체 생성 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void cannotMakeRacingGameMachine(int tryCounts) {
        assertThatThrownBy(() -> new RacingGameMachine(DUMMY_CARS, tryCounts))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("게임 시도 회수는 양의 정수여야 합니다.");
    }
}
