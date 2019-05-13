package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarTest {

    private RacingCar racingCar;
    private List<Car> cars = new ArrayList<>();

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar();
        cars.add(new Car("pobi"));
        cars.add(new Car("crong"));
    }

    @Test
    void create() {
        CarGenerator carGenerator = new CarGenerator();
        RacingCar racingCar = new RacingCar(carGenerator, cars);

        assertThat(racingCar.equals(new RacingCar(carGenerator, cars)));
    }

    @Test
    void 제대로_자동차리스트가_리턴되는지_테스트() {
        List<Car> cars = racingCar.createCar("a,b,c,d".split(","));
        System.out.println(cars.toString());
    }

    @Test
    void 자동차가_움직이는지_테스트() {
        List<Car> resultCars = racingCar.race(cars, 5);
        assertThat(resultCars.toString()).isEqualTo("[Car{name='pobi', position=1}, Car{name='crong', position=1}]");
    }

    @Test
    void 자동차가_안움직이는지_테스트() {
        List<Car> resultCars = racingCar.race(cars, 4);
        assertThat(resultCars.toString()).isEqualTo("[Car{name='pobi', position=0}, Car{name='crong', position=0}]");
    }
}