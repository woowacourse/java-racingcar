package racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class CarTest {

    @ParameterizedTest
    @CsvSource(value={"3:0","4:1"},delimiter=':')
    public void move(int input, int expected) {
        Car car = new Car("test");
        car.move(input);
        assertThat(car.getDistance()).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings={"","banana"})
    void validate(String input) {
        assertThatThrownBy(() -> {
            new Car(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("길이가 1에서 5사이의 이름을 입력해주세요.");
    }
}
