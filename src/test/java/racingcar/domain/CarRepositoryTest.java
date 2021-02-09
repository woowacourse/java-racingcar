package racingcar.domain;


import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarRepositoryTest {
    private final CarRepository carRepository = new CarRepository();
    private final List<Car> cars = new ArrayList<>();
    private final Car car1 = new Car("111");
    private final Car car2 = new Car("222");
    private final Car car3 = new Car("333");

    @BeforeEach
    void saveCars() {
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        carRepository.saveAll(cars);
    }

    @DisplayName("리스트의 자동차 객체들 모두 저장 및 반환")
    @Test
    void saveAllCars() {
        List<Car> allSavedCars = carRepository.getAllCars();
        Assertions.assertThat(allSavedCars.containsAll(cars)).isTrue();
    }

    @DisplayName("우승 자동차들 반환 - 우승자 : car1")
    @Test
    void getWinners1() {
        car1.goForward();
        List<Car> winners = carRepository.getWinners();
        Assertions.assertThat(winners.size()).isEqualTo(1);
        Assertions.assertThat(winners.contains(car1)).isTrue();
    }

    @DisplayName("우승 자동차들 반환 - 우승자 : car1, car2")
    @Test
    void getWinners2() {
        car1.goForward();
        car2.goForward();
        List<Car> winners = carRepository.getWinners();
        Assertions.assertThat(winners.size()).isEqualTo(2);
        Assertions.assertThat(winners.contains(car1)).isTrue();
        Assertions.assertThat(winners.contains(car2)).isTrue();
    }

    @DisplayName("우승 자동차들 반환 - 우승자 : car1, car2, car3")
    @Test
    void getWinners3() {
        car1.goForward();
        car2.goForward();
        car3.goForward();
        List<Car> winners = carRepository.getWinners();
        Assertions.assertThat(winners.size()).isEqualTo(3);
        Assertions.assertThat(winners.contains(car1)).isTrue();
        Assertions.assertThat(winners.contains(car2)).isTrue();
        Assertions.assertThat(winners.contains(car3)).isTrue();
    }
}