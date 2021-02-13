package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Cars;
import racingcar.domain.RacingGameFactory;
import racingcar.domain.Trial;
import racingcar.domain.car.Car;
import racingcar.domain.car.Name;

public class RacingGameFactoryTest {

    @Test
    @DisplayName("정상적인 경주할 자동차 이름들 입력")
    void generateCarsTest_정상_입력() {
        final List<Car> cars = new ArrayList<>();
        cars.add(new Car(new Name("루트")));
        cars.add(new Car(new Name("소롱")));
        final Cars expected = new Cars(cars);

        final Cars actual = RacingGameFactory.generateCars("루트,소롱");
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("경주할 자동차 이름이 하나인 경우 예외 처리")
    @ValueSource(strings = {"한자동차", "자동차#;"})
    void generateCarsTest_자동차_하나(String input) {
        assertThatThrownBy(() -> {
            final Cars cars = RacingGameFactory.generateCars(input);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차는 두 대 이상 입력해야 합니다.");
    }

    @ParameterizedTest
    @DisplayName("중복되는 경주할 자동차 이름이 있는 경우 예외 처리")
    @ValueSource(strings = {"루트,소롱,루트", "루트,루트,루트"})
    void generateCarsTest_중복되는_자동차_입력(String input) {
        assertThatThrownBy(() -> {
            final Cars cars = RacingGameFactory.generateCars(input);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("중복되는 이름을 입력할 수 없습니다.");
    }

    @ParameterizedTest
    @DisplayName("이동 시도할 회수 입력이 Integer 범위 밖인 경우 예외 처리")
    @ValueSource(strings = {"2147483648", "9999999999"})
    void generateTrialTest_Integer_밖의_숫자(String input) {
        assertThatThrownBy(() -> {
            final Trial trial = RacingGameFactory.generateTrial(input);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Integer");
    }

    @ParameterizedTest
    @DisplayName("이동 시도할 회수 입력이 숫자가 아닌 입력을 한 경우 예외 처리")
    @EmptySource
    @ValueSource(strings = {"2-1", "abc", "894-", "+3"})
    void generateTrialTest_정수가_아닌_입력(String input) {
        assertThatThrownBy(() -> {
            final Trial trial = RacingGameFactory.generateTrial(input);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("숫자만 입력할 수 있습니다.");
    }
}
