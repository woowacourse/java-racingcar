package racingcar.domain.game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Lap 은 ")
class LapTest {

    @Test
    @DisplayName("전체 바퀴 수를 받아 생성된다.")
    void test_1() {
        // given
        int totalLap = 10;
        Lap lap = new Lap(totalLap);

        // when & then
        Assertions.assertThat(lap.getTotalLap()).isEqualTo(totalLap);
    }

    @Test
    @DisplayName("next() 실행 시 currentLap을 1 만큼 증가시킨다.")
    void test_2() {
        // given
        int totalLap = 10;
        Lap lap = new Lap(totalLap);

        // when
        lap.next();

        // then
        Assertions.assertThat(lap.getCurrentLap()).isEqualTo(1);
    }

    @Test
    @DisplayName("next() 실행 시 모든 바퀴를 다 돌았다면 예외를 발생시킨다.")
    void test_3() {
        // given
        int totalLap = 1;
        Lap lap = new Lap(totalLap);
        lap.next();

        // when & then
        Assertions.assertThatThrownBy(lap::next)
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("hasNext() 는 전체 바퀴 수 만큼 진행되지 않은 경우 true를 반환한다.")
    void test_4() {
        // given
        int totalLap = 10;
        Lap lap = new Lap(totalLap);

        // when & then
        for (int i = 0; i < totalLap - 1; i++) {
            Assertions.assertThat(lap.hasNext()).isTrue();
            lap.next();
        }
    }
}