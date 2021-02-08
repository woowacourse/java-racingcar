package racingCar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.domain.Car;
import racingCar.domain.Cars;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    Cars cars;

    @BeforeEach
    void setUp() {
        List<Car> rawCars = new ArrayList<>();
        rawCars.add(new Car("car1"));
        rawCars.add(new Car("car2"));
        rawCars.add(new Car("car3"));
        cars = new Cars(rawCars);
        cars.getCars().get(1).move(4);
        cars.getCars().get(2).move(4);
    }

    @Test
    @DisplayName("최대거리가 제대로 계산되는지 테스트")
    void getMaxPosition() {
        assertThat(cars.getMaxDistance()).isEqualTo(1);
        cars.getCars().get(2).move(4);
        assertThat(cars.getMaxDistance()).isEqualTo(2);
    }

    @Test
    @DisplayName("우승자의 이름을 잘 가져오는지 테스트")
    void getWinnerNames() {
        List<String> winnerNames = cars.getWinnerNames();
        assertThat(winnerNames.size()).isEqualTo(2);
        assertThat(winnerNames.get(0)).isEqualTo("car2");
        assertThat(winnerNames.get(1)).isEqualTo("car3");
        cars.getCars().get(2).move(4);
        winnerNames = cars.getWinnerNames();
        assertThat(winnerNames.size()).isEqualTo(1);
        assertThat(winnerNames.get(0)).isEqualTo("car3");
    }
}
