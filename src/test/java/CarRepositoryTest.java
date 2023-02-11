import domain.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.CarRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarRepositoryTest {
    CarRepository carRepository;
    @BeforeEach
    void setUp() {
        carRepository = new CarRepository();

        carRepository.saveCar(new Car("car1"));
        carRepository.saveCar(new Car("car2"));
        carRepository.saveCar(new Car("car3"));
        carRepository.poweInjectionByName("car1", 5);
        carRepository.poweInjectionByName("car1", 5);
        carRepository.poweInjectionByName("car2", 5);
        carRepository.poweInjectionByName("car2", 5);
        carRepository.poweInjectionByName("car3", 5);


    }

    @DisplayName("자동차 이름의 따른 자동차 위치 리턴 테스트")
    @Test
    void findPositionByNameTest() {
        int result = carRepository.findPositionByName("car1");
        assertThat(result).isEqualTo(2);
    }

    @DisplayName("위치의 있는 자동차 참,거짓 테스트")
    @Test
    void findNameByPositionTest() {
        List<String> carNames = carRepository.findNameByPosition(2);
        assertThat(carNames.contains("car1")).isTrue();
        assertThat(carNames.contains("car2")).isTrue();
        assertThat(carNames.contains("car3")).isFalse();
    }

    @DisplayName("파워의 따른 자동차 이동 테스트")
    @Test
    void poweInjectionByNameTest() {
        carRepository.poweInjectionByName("car1",5);
        int result = carRepository.findPositionByName("car1");
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("우승자를 리턴 테스트")
    @Test
    void selectWinnersTest() {
        List<String> winners = carRepository.selectWinners();
        assertThat(winners).isEqualTo(List.of("car1", "car2"));
    }

}