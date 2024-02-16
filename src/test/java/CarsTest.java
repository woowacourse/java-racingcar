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
    @DisplayName("차들 객체를 생성한다.")
    void cars() {
        assertThatCode(Cars::fromEmpty).doesNotThrowAnyException();
    }


    @Test
    @DisplayName("차들을 움직이면 거리가 늘어난다.")
    void carsMove() {
        Cars cars = Cars.fromEmpty();
        cars.move(new RandomMovementGenerator(new RandomNumberGenerator()));
    }

    @Test
    @DisplayName("최대 거리인 자동차들를 구한다")
    void getMaxDistance() {
        Car pobi = Car.of("포비", 1);
        Car kirby = Car.of("커비", 10);
        Car jonge = Car.of("종이", 10);

        Cars cars = Cars.from(List.of(pobi, kirby, jonge));
        assertThat(cars.getWinners().winners()).contains(kirby, jonge);
    }
}
