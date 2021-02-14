package racingCar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;
import racingCar.domain.car.Position;

class PositionTest {

    @Test
    public void create() {
        final Position position = new Position(0);
        assertThat(position).isEqualTo(new Position(0));
    }

    @Test
    public void 유효성_검사() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Position(-1));
    }

    @Test
    public void 이동() {
        final Position position = new Position(1);
        final Position actual = position.goForward();
        assertThat(actual).isEqualTo(new Position(2));
    }

    @Test
    public void 같은_인스턴스() {
        assertThat(Position.ZERO).isSameAs(Position.ZERO);
    }

}