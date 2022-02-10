package racingcar.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class CarRepositoryTest {

    CarRepository carRepository;

    @BeforeEach
    public void setUp() {
        carRepository = new CarRepository();
    }

    @Test
    public void 자동차객체_저장후_조회() {
        Car car = Car.from("pobi");
        carRepository.save(car);
        assertThat(carRepository.findByName("pobi")).isEqualTo(car);
    }
}
