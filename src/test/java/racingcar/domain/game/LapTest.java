package racingcar.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Lap 은 ")
class LapTest {

    private static final int LAP_VALUE = 10;
    private final Lap lap = Lap.totalLap(LAP_VALUE);

    @Test
    @DisplayName("바퀴 수를 받아 생성된다.")
    void test_1() {
        // when & then
        assertThat(lap.value()).isEqualTo(LAP_VALUE);
    }

    @Test
    @DisplayName("increase() 실행 시 1 증가된 lap 값을 반환한다.")
    void test_2() {
        // when
        Lap increaseLap = lap.increase();

        // then
        assertThat(increaseLap.value()).isEqualTo(lap.value() + 1);
    }

    @ParameterizedTest(name = "lap 생성 시 1 미만의 값이 들어오면 예외를 발생한다.")
    @ValueSource(ints = {-1, 0})
    void test_3(final int labValue) {

        // when & then
        assertThatThrownBy(() -> Lap.totalLap(labValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("equals 시 lap의 값이 같다면 true를 반환한다.")
    void test_4() {
        // given
        Lap lap1 = Lap.totalLap(LAP_VALUE);
        Lap lap2 = Lap.totalLap(LAP_VALUE);

        // when & then
        assertThat(lap1.equals(lap2)).isTrue();
    }
}