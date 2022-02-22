package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.service.MoveOrStop;
import racingcar.utils.ExceptionMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {
    private Cars cars = new Cars(Arrays.asList("abc", "def", "ghi"));
    private boolean[] definedmoveOrStop = {false, true, true};
    private int index = 0;
    private MoveOrStop moveOrStop = () -> definedmoveOrStop[index++];

    @BeforeEach
    void setUp() {
        cars.move(moveOrStop);
    }

    @Test
    @DisplayName("자동차 이름 간 중복이 있을 경우 예외를 발생시킵니다.")
    void create_duplicatedCarNames() {
        List<String> duplicatedCarNames = Arrays.asList("a", "a", "b");
        assertThatThrownBy(() -> new Cars(duplicatedCarNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.DUPLICATED_CAR_NAMES);
    }

    @Test
    @DisplayName("가장 멀리 간 자동차들을 반환한다.")
    void getFarthestCar() {
        List<Car> actual = cars.getFarthestCars();
        List<String> actualCarNames = actual.stream()
                .map(Car::getCarName)
                .collect(Collectors.toUnmodifiableList());
        assertThat(actualCarNames).contains("def", "ghi");
    }
}
