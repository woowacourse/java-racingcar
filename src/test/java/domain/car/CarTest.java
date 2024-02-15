package domain.car;

import domain.random.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @DisplayName("유효한 자동차 이름을 입력하면 Car객체를 반환한다.")
    @Test
    void initCar() throws Exception {
        // Given
        RandomNumberGenerator randomNumberGenerator = (start, end) -> 5;
        String carName = "Car";

        // When
        Car car = new Car(randomNumberGenerator, carName);

        // Then
        assertThat(car).isNotNull();
    }

    @DisplayName("5보다 큰 길이의 이름을 입력하면 예외가 발생한다.")
    @Test
    void createCarThrowExceptionWhenInputInvalidName() throws Exception {
        // Given
        RandomNumberGenerator randomNumberGenerator = (start, end) -> 5;
        String soLongCarName = "chicken-boy";

        // When & Then
        assertThatThrownBy(() -> new Car(randomNumberGenerator, soLongCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름 길이는 1이상 5이하의 문자열만 가능합니다.");
    }

    @DisplayName("공백의 이름을 입력하면 예외가 발생한다.")
    @Test
    void createCarThrowExceptionWhenInputEmptyName() throws Exception {
        // Given
        RandomNumberGenerator randomNumberGenerator = (start, end) -> 5;
        String emptyName = "";

        // When & Then
        assertThatThrownBy(() -> new Car(randomNumberGenerator, emptyName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름 길이는 1이상 5이하의 문자열만 가능합니다.");
    }

    @DisplayName("RandomNumberGenerator가 전달되지 않으면 예외가 발생한다.")
    @Test
    void createCarThrowExceptionWhenInputNull() throws Exception {
        // Given
        RandomNumberGenerator randomNumberGenerator = null;
        String carName = "car";

        // When & Then
        assertThatThrownBy(() -> new Car(randomNumberGenerator, carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("RandomNumberGenerator가 존재하지 않습니다.");
    }

    @DisplayName("4이상의 난수가 뽑히면 전진한다.")
    @Test
    void forwardCar() throws Exception {
        // Given
        RandomNumberGenerator randomNumberGenerator = (start, end) -> 5;
        Car car = new Car(randomNumberGenerator, "test");

        // When
        car.move();
        int distance = car.getStatus().distance();

        // Then
        assertThat(distance).isEqualTo(1);
    }

    @DisplayName("3이하의 난수가 뽑히면 전진하지 않는다.")
    @Test
    void notForwardCar() throws Exception {
        // Given
        RandomNumberGenerator randomNumberGenerator = (start, end) -> 2;
        Car car = new Car(randomNumberGenerator, "test");

        // When
        car.move();
        int distance = car.getStatus().distance();

        // Then
        assertThat(distance).isEqualTo(0);
    }
}
