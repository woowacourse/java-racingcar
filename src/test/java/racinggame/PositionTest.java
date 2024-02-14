package racinggame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @DisplayName("자동차 위치를 생성한다.")
    @Test
    void create() {
        Assertions.assertThatCode(() -> Position.from(1))
            .doesNotThrowAnyException();
    }

    @DisplayName("자동차 위치가 같으면 동등하다.")
    @Test
    void equalsAndHashSuccess() {
        Position one = Position.from(1);
        Position other = Position.from(1);

        assertThat(one).isEqualTo(other);
    }

    @DisplayName("자동차 위치가 다르면 동등하지 않다")
    @Test
    void equalsAndHashFail() {
        Position one = Position.from(1);
        Position other = Position.from(2);

        assertThat(one).isNotEqualTo(other);
    }

    @DisplayName("자동차 위치는 음수가 될 수 없다.")
    @Test
    void createNonNegative() {
        assertThatCode(() -> Position.from(-1))
            .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("자동차 위치가 양수라면 에러가 반환되지 않는다.")
    @Test
    void createPositive() {
        assertThatCode(() -> Position.from(1))
            .doesNotThrowAnyException();
    }

    @DisplayName("자동차의 위치를 증가시킨다.")
    @Test
    void positionIncrease() {
        int initialValue = 0;
        Position position = Position.from(initialValue);

        assertThat(position.increase()).isEqualTo(Position.from(initialValue + 1));
    }

}
