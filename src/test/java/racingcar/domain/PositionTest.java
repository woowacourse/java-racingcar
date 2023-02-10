package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Position 은 ")
public class PositionTest {

    @Test
    @DisplayName("init()을 호출하면 0으로 초기화된 position을 반환한다.")
    void test1() {
        Position position = Position.init();

        assertThat(position.getValue()).isEqualTo(0);
    }

    @Test
    @DisplayName("equals 시 같은 위치인 경우 true를 반환한다.")
    void test_2() {
        // given
        Position pos1 = Position.init();
        Position pos2 = Position.init();

        // when & then
        assertThat(pos1).isEqualTo(pos2);
    }

    @Test
    @DisplayName("increase() 시 값이 1 증가된 Position을 반환한다")
    void test_3() {
        // given
        Position beforePosition = Position.init();

        // when
        Position increasePosition = beforePosition.increase();

        // then
        assertThat(increasePosition.getValue())
                .isEqualTo(beforePosition.getValue() + 1);
    }
}