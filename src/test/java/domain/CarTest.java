package domain;

import domain.car.CarName;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("4이상의 난수가 뽑히면 전진한다.")
    @Test
    void forwardCar() {
        // Given
        NumberRangeGenerator numberRangeGenerator = (start, end) -> 5;
        Car car = new Car(numberRangeGenerator, new CarName("test"));

        // When
        car.move();
        int distance = car.getDistance();

        // Then
        assertThat(distance).isEqualTo(1);
    }

    @DisplayName("3이하의 난수가 뽑히면 전진하지 않는다.")
    @Test
    void notForwardCar() {
        // Given
        NumberRangeGenerator numberRangeGenerator = (start, end) -> 2;
        Car car = new Car(numberRangeGenerator, new CarName("test"));

        // When
        car.move();
        int distance = car.getDistance();

        // Then
        assertThat(distance).isZero();
    }

    @DisplayName("5보다 큰 길이의 이름을 입력하면 예외가 발생합니다.")
    @Test
    void createCarThrowExceptionWhenInputInvalidName() {
        // Given
        String soLongCarName = "chicken-boy";

        // When & Then
        Assertions.assertThatThrownBy(() -> new Car(null, new CarName(soLongCarName)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름 길이는 1이상 5이하의 문자열만 가능합니다.");
    }

    @DisplayName("공백의 이름을 입력하면 예외가 발생합니다.")
    @Test
    void createCarThrowExceptionWhenInputEmptyName() {
        // Given
        String emptyName = "";

        // When & Then
        Assertions.assertThatThrownBy(() -> new Car(new RandomNumberRangeGenerator(), new CarName(emptyName)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름 길이는 1이상 5이하의 문자열만 가능합니다.");
    }

    @DisplayName("잘못된 이름을 입력하면 예외가 발생합니다.")
    @ParameterizedTest
    @CsvSource({
            "chicken-boy, 이름 길이는 1이상 5이하의 문자열만 가능합니다.",
            "'', 이름 길이는 1이상 5이하의 문자열만 가능합니다."
    })
    void createCarThrowExceptionForInvalidName(String inputName, String expectedMessage) {
        Assertions.assertThatThrownBy(() -> new Car(new RandomNumberRangeGenerator(), new CarName(inputName)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);
    }
}
