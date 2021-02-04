package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @DisplayName("Cars 객체를 생성하는 기능을 테스트한다")
    @Test
    void testInitCars() {
        //given
        List<Car> carGroup = Arrays.asList(new Car("benz"), new Car("kia"));

        //when
        Cars cars = new Cars(carGroup);

        //then
        assertThat(cars.getCars()).isEqualTo(carGroup);
    }

    @DisplayName("중복되는 자동차이름이 있는 경우 예외를 발생시킨다.")
    @Test
    void testInitCarsIfExistDuplicatedCarNames() {
        //given
        List<Car> carGroup = Arrays.asList(new Car("benz"), new Car("kia"), new Car("benz"));

        //when //then
        assertThatThrownBy(() -> new Cars(carGroup))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}