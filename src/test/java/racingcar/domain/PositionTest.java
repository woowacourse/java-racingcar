package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Position 은 ")
public class PositionTest {

    @ParameterizedTest(name = "이름이 5글자 이하인 경우(EX: [{arguments}]) 생성된다.")
    @ValueSource(strings = {
            "1", "12", "123", "1234", "12345"
    })
    void sample(final String name) {
        Assertions.assertDoesNotThrow(() -> new Name(name));
    }

    @Test
    @DisplayName("init()을 호출하면 0으로 초기화된 position을 반환한다.")
    void test1() {
        Position position = Position.init();

        assertThat(position.getValue()).isEqualTo(0);
    }

    @ParameterizedTest(name = "move 시 파라미터가 4 이상이면 전진한다.")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void test2(final int param) {
        Position position = Position.init();
        Position nextPosition = position.move(param);
        assertThat(nextPosition.getValue()).isEqualTo(position.getValue() + 1);
    }

    @ParameterizedTest(name = "move 시 파라미터가 3 이하이면 멈춘다.")
    @ValueSource(ints = {0, 1, 2, 3})
    void test3(final int param) {
        Position position = Position.init();
        Position nextPosition = position.move(param);
        assertThat(nextPosition.getValue()).isEqualTo(position.getValue());
    }

    @ParameterizedTest(name = "move 시 파라미터가 0~9사이의 숫자가 아니면 예외가 발생한다.")
    @ValueSource(ints = {-1, 10})
    void test4(final int param) {
        Position position = Position.init();
        assertThatThrownBy(
                () -> position.move(param)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("equals 시 같은 위치인 경우 true를 반환한다.")
    void test_5() {
        // given
        Position pos1 = Position.init();
        Position pos2 = Position.init();

        // when & then
        assertThat(pos1).isEqualTo(pos2);
    }

    @Test
    @DisplayName("increase() 시 값이 1 증가된 Position을 반환한다")
    void test_6() {
        // given
        Position beforePosition = Position.init();

        // when
        Position increasePosition = beforePosition.increase();

        // then
        assertThat(increasePosition.getValue())
                .isEqualTo(beforePosition.getValue() + 1);
    }
}