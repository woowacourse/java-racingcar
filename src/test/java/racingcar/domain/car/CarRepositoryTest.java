package racingcar.domain.car;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarRepositoryTest {

    private static final List<Car> testCars = new ArrayList<>();
    private static final List<Car> expectWinners = new ArrayList<>();

    @BeforeAll
    static void set() {
        Car car1 = new Car("java");
        Car car2 = new Car("html");
        Car car3 = new Car("c++");
        car2.tryToMoveForward(9);
        car3.tryToMoveForward(9);
        testCars.add(car1);
        testCars.add(car2);
        testCars.add(car3);
        expectWinners.add(car2);
        expectWinners.add(car3);
        CarRepository.addCars(testCars);
    }

    @Test
    @DisplayName("addCars 메소드를 이용하여 car들이 추가되는지 테스트")
    void addCars() {
        assertThat(testCars.containsAll(CarRepository.cars()));
    }

    @Test
    @DisplayName("우승자들이 나오는지 테스트")
    void selectWinners() {
        CarRepository.addCars(testCars);
        List<Car> actualWinners = CarRepository.selectWinners(1);
        assertThat(actualWinners.containsAll(expectWinners));
    }
}