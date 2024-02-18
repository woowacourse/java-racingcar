package domain;

import domain.car.CarDistance;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class CarsTest {
    @DisplayName("자동차들의 최대 전진 거리를 구한다.")
    @Test
    void getMaxDistance() {
        // Given
        Cars cars = new Cars(List.of(
                Car.createCar("test1", 0),
                Car.createCar("test2", 3),
                Car.createCar("test3", 3)));

        // When
        CarDistance maxDistance = cars.getMaxDistance();

        // Then
        Assertions.assertThat(maxDistance).isEqualTo(new CarDistance(3));
    }
}
