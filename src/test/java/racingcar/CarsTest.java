package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class CarsTest {

    @Test
    @DisplayName("정상적인 경주할 자동차 이름들 입력")
    void getInstanceTest_정상_입력() {
        final List<Car> cars = new ArrayList<>();
        cars.add(new Car("루트"));
        cars.add(new Car("소롱"));
        final Cars expected = new Cars(cars);

        final Cars actual = Cars.getInstance("루트,소롱");
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("경주할 자동차 이름이 하나인 경우 예외 처리")
    @ValueSource(strings = {"한자동차", "자동차#;"})
    void getInstanceTest_자동차_하나(String input) {
        assertThatThrownBy(() -> {
            final Cars cars = Cars.getInstance(input);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차는 두 대 이상 입력해야 합니다.");
    }

    @ParameterizedTest
    @DisplayName("중복되는 경주할 자동차 이름이 있는 경우 예외 처리")
    @ValueSource(strings = {"루트,소롱,루트", "루트,루트,루트"})
    void getInstance_중복되는_자동차_입력(String input) {
        assertThatThrownBy(() -> {
            final Cars cars = Cars.getInstance(input);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("중복되는 이름을 입력할 수 없습니다.");
    }
}
