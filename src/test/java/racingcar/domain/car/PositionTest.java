package racingcar.domain.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    @DisplayName("Position 객체 생성")
    void create() {
        final Position position = new Position(1);
        assertThat(position).isEqualTo(new Position(1));
    }

    @Test
    @DisplayName("Position 유효성 검사")
    void validatePosition() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Position(-1);
        });
    }

    @Test
    @DisplayName("이동 테스트")
    void moveTest() {
        final Position position = new Position(1);
        final Position actual = position.move();
        assertThat(actual).isEqualTo(new Position(2));
    }

    @Test
    @DisplayName("ZERO 클래스 상수 비교")
    void zeroTest() {
        assertThat(Position.ZERO).isSameAs(Position.ZERO);
    }
}