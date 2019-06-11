package domain;

import exception.NegativeDistanceException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DistanceTest {
    @Test
    void 생성자_음의_거리() {
        assertThrows(NegativeDistanceException.class, () -> Distance.from(-1));
    }

    @Test
    void increased_() {
        int num = 10;
        Distance distance = Distance.from(num);

        assertThat(distance.increased()).isEqualTo(Distance.from(num + 1));
    }
}