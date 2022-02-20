package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarServiceTest {
    @Test
    @DisplayName("이름 리스트를 입력 받아, 자동차들을 생성한다.")
    void createCars() {
        CarService carService = new CarService();
        List<String> names = Arrays.asList("범고래", "소주캉");
        carService.createCars(names);
        List<CarDto> carDtos = carService.findCarDtos();
        assertThat(carDtos.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("자동차 생성 중 중복된 이름 입력 시, RuntimeException을 thorw한다.")
    void validateDuplication() {
        assertThatThrownBy(() -> {
            CarService carService = new CarService();
            List<String> names = Arrays.asList("범고래", "범고래");
            carService.createCars(names);
        }).hasMessageContaining("중복된 이름이 존재합니다.")
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("자동차 리스트를 Dto로 바꾸어 반환한다.")
    void findCarDtos() {
        CarService carService = new CarService();
        List<String> names = Arrays.asList("범고래", "소주캉");
        carService.createCars(names);
        List<CarDto> carDtos = carService.findCarDtos();
        assertThat(carDtos.get(0)).isEqualTo(new CarDto("범고래"));
    }
}
