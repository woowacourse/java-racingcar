package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.LinkedHashMap;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        assertThatThrownBy(() -> new Cars(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차별 현재 위치 정보를 반환한다.")
    @Test
    void getRoundResult() {
        //given
        String givenName = "daon";
        int givenPosition = 1;

        List<Car> givenCars = List.of(
                new Car(givenName, givenPosition),
                new Car("ted", 2)
        );
        Cars cars = new Cars(givenCars);

        //when
        RoundResult roundResult = cars.getRoundResult();
        LinkedHashMap<String, Integer> result = roundResult.getResult();

        //then
        assertThat(result).hasSize(givenCars.size());
        assertThat(result.get(givenName)).isEqualTo(givenPosition);
    }
}