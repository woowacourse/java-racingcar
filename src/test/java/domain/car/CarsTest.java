package domain.car;

import domain.random.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @DisplayName("자동차들의 최대 전진 거리를 구한다.")
    @Test
    void getMaxDistance() throws Exception {
        // Given
        RandomNumberGenerator randomNumberGenerator = (start, end) -> 5;
        Cars cars = new Cars(List.of
                (new Car(randomNumberGenerator, "test1", 0),
                        new Car(randomNumberGenerator, "test2", 3),
                        new Car(randomNumberGenerator, "test3", 3)));

        // When
        int maxDistance = cars.getMaxDistance();

        // Then
        assertThat(maxDistance).isEqualTo(3);
    }
}
