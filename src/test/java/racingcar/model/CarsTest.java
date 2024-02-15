package racingcar.model;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @DisplayName("중복된 이름이 있으면 예외를 발생한다.")
    @Test
    void duplicateCarNameTest() {
        // given
        List<String> names = List.of("car1", "car1", "car2");

        // when
        List<Car> carList = names.stream().map(Car::new).toList();

        // then
        Assertions.assertThatThrownBy(() -> new Cars(carList))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
