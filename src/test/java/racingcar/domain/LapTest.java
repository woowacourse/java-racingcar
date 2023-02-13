package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@DisplayName("Lap 은 ")
class LapTest {

    @Test
    @DisplayName("run()시 countTryLap을 하나씩 증가시킨다.")
    void test_1() {
        // given
        Lap lap = new Lap(5);
        int beforeRun = lap.getCountTryLap();

        // when
        lap.run();

        // then
        Assertions.assertThat(lap.getCountTryLap()).isEqualTo(beforeRun + 1);
    }

    @Test
    @DisplayName("isNotSame()시 countTryLap과 totalLap이 같은지 다른지 판별한다.")
    void test_2() {
        // given
        Lap lap = new Lap(1);

        // when
        lap.run();

        // then
        Assertions.assertThat(lap.isNotSame()).isEqualTo(true);
    }

    @Test
    @DisplayName("시도 회수를 0보다 작은 숫자를 입력했을때 예외를 발생시킨다.")
    void test_3() {
        assertThatThrownBy(()->new Lap(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }}
