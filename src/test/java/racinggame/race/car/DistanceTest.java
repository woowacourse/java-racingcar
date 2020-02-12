package racinggame.race.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DistanceTest {

    @DisplayName("거리가 1늘어난다.")
    @Test
    void move() {
        Distance distance = Distance.startingPosition();
        assertThat(distance.isEqual(1)).isTrue();

        distance = distance.move();
        assertThat(distance.isEqual(2)).isTrue();
    }

}