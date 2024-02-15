package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.LinkedHashMap;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.generator.MovingStub;

class CarsTest {

    @DisplayName("중복되는 자동차 이름이 있을 경우 예외가 발생한다.")
    @Test
    void exceptionByDuplicate() {
        //given
        List<String> names = List.of("a", "a", "c");
        List<Car> cars = names.stream()
                .map(Car::new)
                .toList();

        //when //then
        assertThatThrownBy(() -> new Cars(cars, new MovingStub(List.of(4, 3, 3))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차별 현재 위치 정보를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"5,1", "3,0"})
    void getCarStatus(int givenNumber, int expected) {
        //given
        String carName = "a";
        List<String> names = List.of(carName, "b", "c");
        List<Car> givenCars = names.stream()

                .map(Car::new)
                .toList();

        //when
        Cars cars = new Cars(givenCars, new MovingStub(List.of(givenNumber, 3, 3)));
        RoundResult roundResult = cars.makeCarsMove();
        LinkedHashMap<String, Integer> result = roundResult.getResult();

        //then
        assertThat(result).hasSize(givenCars.size());
        assertThat(result.get(carName)).isEqualTo(expected);
    }
}