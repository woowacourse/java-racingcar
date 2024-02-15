package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DistanceTest {

    @Test
    @DisplayName("거리가 증가하는지 확인한다")
    void increase() {
        Distance distance = Distance.init();
        distance.increase();
        Assertions.assertThat(distance.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("같은 거리 값을 갖는 객체인지 확인하다")
    void isSameDistance() {
        Distance distance = Distance.from(2);
        Distance otherDistance = Distance.from(2);
        Assertions.assertThat(distance).isEqualTo(otherDistance);
    }
}