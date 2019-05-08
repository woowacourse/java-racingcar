package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void isMoveTest() {
        assertThat(Car.isMove(4)).isEqualTo(true);
        assertThat(Car.isMove(2)).isEqualTo(false);
    }
}
