import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        carRepository.addPosition("car1");
        carRepository.addPosition("car1");
        carRepository.addPosition("car2");
        carRepository.addPosition("car2");
        carRepository.addPosition("car3");
    }

    @Test
    void findPositionByName() {
        int result = carRepository.findPositionByName("car1");
        assertThat(result).isEqualTo(2);
    }
}