package racingcar.model.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.car.Car;
import racingcar.model.car.CarDto;
import racingcar.model.car.Cars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    @DisplayName("자동차를 CarRepository에 저장할 때는 Car로 하지만 읽어올 때는 CarDtos로 읽어온다.")
    void getCars() {
        Cars carRepository = new Cars();
        Car car = new Car("범고래");
        carRepository.save(car);

        List<CarDto> cars = carRepository.getCarDtos();
        CarDto carDto = new CarDto(car);
        assertThat(cars.contains(carDto)).isTrue();
    }
}
