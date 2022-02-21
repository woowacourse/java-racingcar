package racingcar.model.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.service.CarDto;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {
    @Test
    @DisplayName("자동차를 CarRepository에 저장할 때는 Car로 하지만 읽어올 때는 CarDtos로 읽어온다.")
    void getCars() {
        Cars cars = new Cars();
        List<String> input = Arrays.asList("범고래", "소주캉");
        cars.create(input);
        List<CarDto> carDtos = cars.getCarDtos();
        CarDto carDto = new CarDto("범고래");
        assertThat(carDtos.contains(carDto)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,0", "3,0", "4,1", "5,1"}, delimiter = ',')
    @DisplayName("자동차들이 입력 받은 랜덤 숫자 값에 따라 4이상이면 전진, 3이하면 정지한다.")
    void move(int input, int actual) {
        Cars cars = new Cars();
        List<String> names = Arrays.asList("범고래", "소주캉");
        cars.create(names);
        cars.move(List.of(input));
        List<CarDto> carDtos = cars.getCarDtos();
        CarDto carDto = carDtos.get(0);
        assertThat(carDto.getPosition()).isEqualTo(actual);
    }

    @Test
    @DisplayName("자동차 이름들을 입력 받아, 자동차를 생성한다.")
    void create() {
        Cars cars = new Cars();
        List<String> input = Arrays.asList("범고래", "소주캉");
        cars.create(input);
        assertThat(cars.getSize()).isEqualTo(2);
    }

    @Test
    @DisplayName("자동차 생성 중 중복된 이름 입력 시, RuntimeException을 thorw한다.")
    void validateDuplication() {
        assertThatThrownBy(() -> {
            Cars cars = new Cars();
            List<String> input = Arrays.asList("범고래", "범고래");
            cars.create(input);
        }).hasMessageContaining("중복된 이름이 존재합니다.")
                .isInstanceOf(RuntimeException.class);
    }
}
