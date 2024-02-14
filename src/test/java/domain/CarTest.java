package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("4이상의 난수가 뽑히면 전진한다.")
    @Test
    void forwardCar() throws Exception {
        // Given
        RandomNumberGenerator randomNumberGenerator = (start, end) -> 5;
        Car car = new Car(randomNumberGenerator, "tester");

        // When
        car.move();

        // Then
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @DisplayName("3이하의 난수가 뽑히면 전진하지 않는다..")
    @Test
    void notForwardCar() throws Exception {
        // Given
        RandomNumberGenerator randomNumberGenerator = (start, end) -> 2;
        Car car = new Car(randomNumberGenerator, "tester");

        // When
        car.move();

        // Then
        assertThat(car.getDistance()).isEqualTo(0);
    }
}
