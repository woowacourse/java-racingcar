package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
class CarStatusTest {
    @Test
    @DisplayName("자동차의 전진과 후진을 판단할 수 있다.")
    void decide(){
        assertAll(
                () -> assertThat(CarStatus.decide(4)).isEqualTo(CarStatus.FORWARD),
                () -> assertThat(CarStatus.decide(3)).isEqualTo(CarStatus.STOP)
        );

    }

}