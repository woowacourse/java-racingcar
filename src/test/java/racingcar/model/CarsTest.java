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
import racingcar.generator.RandomNumberGenerator;

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

    @DisplayName("등록된 자동차에게 전진 명령을 내린다.")
    @Test
    void makeCarsMove() {
        //given
        List<String> names = List.of("a", "b", "c");
        List<Car> givenCars = names.stream()
                .map(Car::new)
                .toList();
        Cars cars = new Cars(givenCars, new RandomNumberGenerator());

        //when
        RoundResult roundResult = cars.makeCarsMove();

        //then
        assertThat(roundResult.getResult()).hasSize(givenCars.size());
    }
}