package racingCar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class CarTest {
    @ParameterizedTest
    @DisplayName("자동차가 3이하면 멈추고 4이상이면 움직이는지 테스트")
    @CsvSource(value = {"3:0", "4:1"}, delimiter = ':')
    void move(int input, int expected) {
        Car car = new Car("test");
        car.move(input);
        assertThat(car.getDistance()).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("자동차 이름이 1~5자리가 아니면 에러가 나는지 테스트")
    @ValueSource(strings = {"", "banana"})
    void validate(String input) {
        assertThatThrownBy(() -> new Car(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("길이가 1에서 5사이의 이름을 입력해주세요.");
    }

    @Test
    @DisplayName("자동차가 우승자인지 아닌지 테스트")
    void isWinner() {
        Car car = new Car("test");
        car.move(4);
        car.move(4);
        assertThat(car.isWinner(2)).isTrue();
        assertThat(car.isWinner(3)).isFalse();
    }
}
