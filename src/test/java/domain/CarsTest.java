package domain;

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
        Cars cars = new Cars(List.of
                (new Car(new RandomNumberRangeGenerator(), "test1", 0),
                        new Car(new RandomNumberRangeGenerator(), "test2", 3),
                        new Car(new RandomNumberRangeGenerator(), "test3", 3)));

        // When
        int maxDistance = cars.getMaxDistance();

        // Then
        Assertions.assertThat(maxDistance).isEqualTo(3);
    }
}
