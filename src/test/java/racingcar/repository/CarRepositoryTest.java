package racingcar.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class CarRepositoryTest {

    private static final String CAR_1_Name = "pobi";
    private static final String CAR_2_Name = "jason";

    CarRepository carRepository;
    Car car1;
    Car car2;

    @BeforeEach
    public void setUp() {
        carRepository = new CarRepository();
        car1 = Car.from(CAR_1_Name);
        car2 = Car.from(CAR_2_Name);
        carRepository.save(car1);
        carRepository.save(car2);
    }

    @Test
    public void 자동차객체_저장후_조회() {
        assertThat(carRepository.findByName(CAR_1_Name)).isEqualTo(car1);
    }

    @Test
    public void 저장된_자동차_객체_전체_조회() {
        assertThat(carRepository.findAll()).contains(car1, car2);
    }
}
