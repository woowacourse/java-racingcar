package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    private Car car = new Car("car");

    @DisplayName("자동차 이름 유효성 검사")
    @Test
    void validateName() {
        assertThatThrownBy(() -> Car.validateName("nameOver5Length"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 포지션 이동 검사")
    @ParameterizedTest
    @CsvSource(value = {"3,0", "4,1"})
    void move(int randomNumber, int position) {
        car.move(randomNumber);
        assertThat(car.getPosition()).isEqualTo(position);
    }
}
