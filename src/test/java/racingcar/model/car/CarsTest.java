package racingcar.model.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.service.CarDto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    Cars cars;
    Car car;

    @BeforeEach
    void setUp() {
        cars = new Cars();
        car = new Car("범고래");
        cars.save(car);
    }

    @Test
    @DisplayName("자동차를 CarRepository에 저장할 때는 Car로 하지만 읽어올 때는 CarDtos로 읽어온다.")
    void getCars() {
        List<CarDto> carDtos = cars.getCarDtos();
        CarDto carDto = new CarDto(car);
        assertThat(carDtos.contains(carDto)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,0", "3,0", "4,1", "5,1"}, delimiter = ',')
    @DisplayName("자동차들이 입력 받은 랜덤 숫자 값에 따라 4이상이면 전진, 3이하면 정지한다.")
    void move(int input, int actual) {
        cars.move(List.of(input));
        assertThat(car.getPosition()).isEqualTo(actual);
    }
}
