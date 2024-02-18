package domain;

import domain.car.CarDistance;
import domain.car.CarName;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {
    @DisplayName("자동차들의 최대 전진 거리를 구한다.")
    @Test
    void getMaxDistance() {
        // Given
        Cars cars = new Cars(List.of(
                new Car(new RandomNumberRangeGenerator(), new CarName("test1"), new CarDistance(0)),
                new Car(new RandomNumberRangeGenerator(), new CarName("test2"), new CarDistance(3)),
                new Car(new RandomNumberRangeGenerator(), new CarName("test3"), new CarDistance(3))));

        // When
        CarDistance maxDistance = cars.getMaxDistance();

        // Then
        Assertions.assertThat(maxDistance).isEqualTo(new CarDistance(3));
    }
}
