package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("정상적인 Cars 객체 생성")
    void createCars() {
        assertThatCode(() -> new Cars("pobi,crong,honux")).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("겹치는 자동차 이름이 존재하면 예외")
    void createCarsWithDuplicateName() {
        assertThatThrownBy(() -> new Cars("pobi, pobi"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("가장 먼 전진 거리를 가진 자동차가 우승")
    void findFurthestCars() {
        List<String> carNames = List.of("pobi", "crong", "honux");
        List<Integer> positions = List.of(1, 2, 3);
        Cars cars = new Cars(carNames, positions);
        List<Car> furthestCars = cars.findFurthestCars();
        assertThat(furthestCars.get(0).getName()).isEqualTo("honux");
    }
}
