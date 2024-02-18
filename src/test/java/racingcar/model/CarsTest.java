package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.model.Car;
import racingcar.domain.model.Cars;

public class CarsTest {

    @DisplayName("중복된 이름이 있으면 예외를 발생한다.")
    @Test
    void duplicateCarNameTest() {
        // given
        List<String> names = List.of("car1", "car1", "car2");

        // when
        List<Car> carList = names.stream().map(Car::new).toList();

        // then
        Assertions.assertThatThrownBy(() -> new Cars(carList)).isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("자동차 대수는 1~40을 벗어날 경우 예외를 발생시킨다.")
    @Test
    void validateTest() {
        //given
        List<Car> carList = new ArrayList<>();
        IntStream.rangeClosed(0, 50).forEach(index -> carList.add(new Car("car" + index)));

        //when & then
        Assertions.assertThatThrownBy(() -> new Cars(carList)).isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("자동차들 중 가장 긴 거리를 이동한 값을 구한다.")
    void getMaxProgressTest() {
        //given
        List<Car> originCars = List.of(new Car("car1"), new Car("car2"), new Car("car3"));
        //when
        originCars.get(1).move();
        originCars.get(1).move();
        originCars.get(0).move();

        Cars cars = new Cars(originCars);
        //then

        Assertions.assertThat(cars.getMaxProgress()).isEqualTo(2);
     }
}
