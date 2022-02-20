package racingcar.domain.vo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {

    @DisplayName("Position() 테스트")
    @Test
    public void constructor_test() throws Exception {
        Position position = new Position();
        assertThat(position.get()).isEqualTo(0);
    }

    @DisplayName("increase() 테스트")
    @Test
    public void increase_test() throws Exception {
        Position position = new Position();
        position = position.increase();
        assertThat(position.get()).isEqualTo(1);
    }

    @DisplayName("compareTo() 테스트")
    @Test
    public void compareTo_test() throws Exception {
        Position positionZero = new Position();
        Position positionOne = new Position();
        positionOne = positionOne.increase();
        assertThat(positionZero.compareTo(positionZero)).isEqualTo(0);
        assertThat(positionZero.compareTo(positionOne)).isLessThan(0);
        assertThat(positionOne.compareTo(positionZero)).isGreaterThan(0);
    }
}
