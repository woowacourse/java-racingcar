package domain.car;

import domain.car.Car;
import domain.car.Cars;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class CarsTest {
    @DisplayName("자동차들의 최대 전진 거리를 구한다.")
    @Test
    void getMaxDistance() throws Exception {
        // Given
        Cars cars = new Cars(List.of
                (new Car(null, "test1", 0),
                        new Car(null, "test2", 3),
                        new Car(null, "test3", 3)));

        // When
        int maxDistance = cars.getMaxDistance();

        // Then
        Assertions.assertThat(maxDistance).isEqualTo(3);
    }
}
