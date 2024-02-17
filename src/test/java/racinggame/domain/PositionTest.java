package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @DisplayName("자동차 위치를 생성한다.")
    @Test
    void create() {
        assertThatCode(() -> new Position(1))
            .doesNotThrowAnyException();
    }

    @DisplayName("자동차 위치가 같으면 동등하다.")
    @Test
    void equalsAndHashSuccess() {
        Position one = new Position(1);
        Position other = new Position(1);

        assertThat(one).isEqualTo(other);
    }

    @DisplayName("자동차 위치가 다르면 동등하지 않다")
    @Test
    void equalsAndHashFail() {
        Position one = new Position(1);
        Position other = new Position(2);

        assertThat(one).isNotEqualTo(other);
    }

    @DisplayName("자동차 위치는 음수가 될 수 없다.")
    @Test
    void createNonNegative() {
        assertThatCode(() -> new Position(-1))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 위치가 양수라면 에러가 반환되지 않는다.")
    @Test
    void createPositive() {
        assertThatCode(() -> new Position(1))
            .doesNotThrowAnyException();
    }

    @DisplayName("자동차의 위치를 증가시킨다.")
    @Test
    void positionIncrease() {
        int initialValue = 0;
        Position position = new Position(initialValue);

        assertThat(position.increase()).isEqualTo(new Position(initialValue + 1));
    }

}
