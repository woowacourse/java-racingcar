package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import domain.Car;
import domain.Cars;
import domain.RandomMovementGenerator;
import domain.RandomNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
    @Test
    @DisplayName("최대 거리인 자동차들를 구한다")
    void getMaxDistance() {
        final Car pobi = Car.of("포비", 1);
        final Car kirby = Car.of("커비", 10);
        final Car jonge = Car.of("종이", 10);
        final Cars cars = Cars.from(List.of(pobi, kirby, jonge));

        assertThat(cars.getMaxDistanceCars()).containsExactly(kirby, jonge);
    }
}
