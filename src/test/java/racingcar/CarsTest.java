package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class CarsTest {

    @ParameterizedTest
    @DisplayName("경주할 자동차 이름이 하나인 경우 예외 처리")
    @ValueSource(strings = {"한자동차", "자동차#;"})
    void newCarsTest_자동차_입력_수(String input) {
        assertThatThrownBy(() -> {
            Cars cars = new Cars(Arrays.asList(new Car(input)));
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차는 두 대 이상 입력해야 합니다.");
    }

    @ParameterizedTest
    @DisplayName("중복되는 경주할 자동차 이름이 있는 경우 예외 처리")
    @MethodSource("provideCarsForNewCarsTest")
    void newCarsTest_중복되는_자동차_입력(List<Car> input) {
        assertThatThrownBy(() -> {
            Cars cars = new Cars(input);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("중복되는 이름을 입력할 수 없습니다.");
    }

    private static Stream<List<Car>> provideCarsForNewCarsTest() {
        return Stream.of(
            Arrays.asList(new Car("루트"), new Car("소롱"), new Car("루트")),
            Arrays.asList(new Car("루트"), new Car("루트"), new Car("루트"))
        );
    }
}
