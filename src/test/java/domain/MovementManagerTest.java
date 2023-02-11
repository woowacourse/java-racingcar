package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MovementManagerTest {
    @Test
    @DisplayName("3 이하의 숫자일 경우 이동하지 않는다.")
    void move_fail() {
        MovementManager movementManager = new MovementManager();
        int power = 3;

        Assertions.assertThat(movementManager.isGo(power)).isEqualTo(false);
    }

    @Test
    @DisplayName("4 이상의 숫자일 경우 전진한다.")
    void move_success() {
        MovementManager movementManager = new MovementManager();
        int power = 4;

        Assertions.assertThat(movementManager.isGo(power)).isEqualTo(true);
    }
}