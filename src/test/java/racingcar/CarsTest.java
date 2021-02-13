package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.domain.car.Car;

public class CarsTest {

    private static List<Car> carList;

    @BeforeEach
    void setUp() {
        carList = new ArrayList<>();
        carList.add(new Car("pobi", 3));
        carList.add(new Car("mt", 2));
    }

    @Test
    @DisplayName("내가 넣은 자동차가 잘 들어갔는지 테스트")
    void carsTest() {
        Cars cars = new Cars(carList);
        assertThat(cars.getCars()).contains(new Car("pobi", 3), new Car("mt", 2));
    }

    @Test
    @DisplayName("cars 생성시 의존성이 끊어졌는지 테스트")
    void carsDependencyTest() {
        Cars cars = new Cars(carList);
        carList.add(new Car("honux", 1));
        assertThat(cars.getCars().size()).isEqualTo(2);
    }
    
    @Test
    @DisplayName("우승자가 잘 나오는지 확인")
    void carsGetWinnersTest() {
        carList.add(new Car("crong", 3));
        Cars cars = new Cars(carList);
        List<Car> winners = cars.getWinners();
        assertThat(winners).contains(new Car("pobi", 3), new Car("crong", 3));
        assertThat(winners.size()).isEqualTo(2);
    }

}
