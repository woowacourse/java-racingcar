package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
                .map(CarName::new)
                .map(Car::new)
                .toList();

        //when //then
        assertThatThrownBy(() -> new Cars(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복될 수 없습니다.");
    }
}
