package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    @DisplayName("move()시 인자가 4이상인 경우 자동차의 위치를 1만큼 움직인다.")
    void test_1() {
        // given
        Position position = new Position();
        int beforeMove = position.getPosition();

        // when
        position.moveOrStop(4);

        // then
        Assertions.assertThat(position.getPosition()).isEqualTo(beforeMove + 1);
    }

    @Test
    @DisplayName("move()시 인자가 3이하인 경우 자동차는 움직이지 않는다.")
    void test_2() {
        // given
        Position position = new Position();
        int beforeMove = position.getPosition();

        // when
        position.moveOrStop(3);

        // then
        Assertions.assertThat(position.getPosition()).isEqualTo(beforeMove);
    }
}
