package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = Car.from("joy");
    }

    @ParameterizedTest
    @DisplayName("4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.")
    @CsvSource(value = {"3,1", "4,2"})
    void drive_validNumber(Integer input, Integer expected) {
        car.drive(input);
        assertThat(car.getPosition()).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("drive에 범위를 벗어난 값을 줌")
    @CsvSource(value = {"-1", "10"})
    void drive_invalidNumber(Integer input) {
        assertThatThrownBy(() -> {
            car.drive(input);
        }).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @DisplayName("올바른 이름으로 Car 생성 성공")
    @ValueSource(strings = {"bepoz  ", "12345", " joy", "b ank"})
    void generate_validName(String input) {
        Car car = Car.from(input);
        assertThat(car.getName()).isEqualTo(input.trim());
    }

    @ParameterizedTest
    @DisplayName("올바르지 않은 이름으로 Car 생성 실패")
    @ValueSource(strings = {"123456", "", " "})
    void generate_invalidName(String input) {
        assertThatThrownBy(() -> {
            Car.from(input);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("Car객체 -> 이름 : 포지션 변환")
    void toString_position1() {
        assertThat(Car.from("joy").toString()).isEqualTo("joy : -");
    }

    @Test
    @DisplayName("Car객체 -> 이름 : 포지션 변환")
    void toString_position2() {
        Car car = Car.from("joy");
        car.drive(5);
        assertThat(car.toString()).isEqualTo("joy : --");
    }
}
