package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
    private static List<Car> cars;

    @BeforeEach
    void createCars() {
        cars = new ArrayList<>();

        Car pobiCar = new Car("pobi");
        pobiCar.moveForward(4);

        Car junCar = new Car("jun");

        Car guguCar = new Car("gugu");
        guguCar.moveForward(4);

        cars.add(pobiCar);
        cars.add(junCar);
        cars.add(guguCar);
    }

    @Test
    @DisplayName("자동차 경주의 한 라운드를 진행한다.")
    void startRounds() {
        Cars cars = new Cars(CarsTest.cars, new FixedNumberGenerator(4));
        cars.startRounds();
        assertThat(cars.getMaxDistance()).isEqualTo(2);
    }

    @Test
    @DisplayName("가장 멀리간 자동차의 거리를 반환해야 한다.")
    void getMostFarDistance() {
        Cars cars = new Cars(CarsTest.cars, new FixedNumberGenerator(0));
        assertEquals(1, cars.getMaxDistance());
    }

    @Test
    @DisplayName("최종 자동차 경주 우승자 정보를 반환해야 한다.")
    void isValidWinnerResult() {
        Cars cars = new Cars(CarsTest.cars, new FixedNumberGenerator(0));
        assertEquals(List.of(new Car("pobi"), new Car("gugu")), cars.getWinners(1));
    }

    static class FixedNumberGenerator implements NumberGenerator {
        private final int number;

        public FixedNumberGenerator(int number) {
            this.number = number;
        }

        public Integer generateNumber() {
            return number;
        }
    }
}
