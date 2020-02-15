package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Position;

public class PositionTest {
    @Test
    void location_값이_큰_경우_양수를_반환() {
        Position greaterPosition = new Position(4);
        Position lessPosition = new Position(1);

        assertThat(greaterPosition.compareTo(lessPosition)).isGreaterThan(0);
    }

    @Test
    void location_값이_작은_경우_음수를_반환() {
        Position greaterPosition = new Position(4);
        Position lessPosition = new Position(1);

        assertThat(lessPosition.compareTo(greaterPosition)).isLessThan(0);
    }

    @Test
    void location_값이_같을_경우_0를_반환() {
        Position position1 = new Position(1);
        Position position2 = new Position(1);

        assertThat(position1.compareTo(position2)).isEqualTo(0);
    }
}
