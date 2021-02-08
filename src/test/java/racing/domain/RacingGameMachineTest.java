package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameMachineTest {
    private static final Cars DUMMY_CARS = Cars.generate("pobi,brown");

    @DisplayName("Cars 객체와 1이상의 tryCounts를 할당받으면, 게임이 시작된다.")
    @Test
    void Machine_Cars_객체와_tryCounts를_입력받으면_게임이_시작된다() {
        int tryCounts = 3;
        RacingGameMachine racingGameMachine = new RacingGameMachine(DUMMY_CARS, tryCounts);
        assertThatCode(() -> racingGameMachine.play())
                .doesNotThrowAnyException();
    }

    @DisplayName("양수가 아닌 수를 할당받으면, 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void Machine_시도횟수가_양수가_아니면_에러가_발생한다(int tryCounts) {
        assertThatThrownBy(() -> new RacingGameMachine(DUMMY_CARS, tryCounts))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("시도횟수는 1회 이상이어야 합니다.");
    }
}