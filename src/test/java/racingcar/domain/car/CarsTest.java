package racingcar.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import racingcar.domain.power.Power;

class CarsTest {
    @DisplayName("자동차들의 최대 전진 거리를 구한다.")
    @Test
    void getMaxDistance() {
        // Given
        Cars cars = Cars.generateCars(List.of("car1", "car2", "car3"));
        Car car = cars.getCars().get(0);

        // When
        for (int i = 0; i < 3; i++) {
            car.move(new Power(9));
        }
        CarDistance maxDistance = cars.getMaxDistance();

        // Then
        Assertions.assertThat(maxDistance).isEqualTo(new CarDistance(3));
    }
}
