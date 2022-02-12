package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarDto;
import racingcar.service.Movement;
import racingcar.utils.ExceptionMessage;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarsTest {
    private final Cars cars = new Cars(Arrays.asList("abc", "def", "ghi"));
    private final boolean[] definedMovement = {false, true, true};
    private int index = 0;
    private final Movement movement = () -> definedMovement[index++];

    @BeforeEach
    void setUp() {
        cars.move(movement);
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
    @DisplayName("자동차들을 전진시키고 반환한다")
    void move_getCars() {
        final List<CarDto> movedCar = cars.getCarInfos();
        final CarDto abc = new CarDto("abc", 0);
        final CarDto def = new CarDto("def", 1);
        final CarDto ghi = new CarDto("ghi", 1);
        final List<CarDto> expected = Arrays.asList(abc, def, ghi);
        assertThat(movedCar).isEqualTo(expected);
    }

    @Test
    @DisplayName("가장 멀리 간 자동차들을 반환한다.")
    void getFarthestCar() {
        final CarDto def = new CarDto("def", 1);
        final CarDto ghi = new CarDto("ghi", 1);
        final List<CarDto> actual = cars.getFarthestCar();
        final List<CarDto> expected = Arrays.asList(def,ghi);
        assertThat(actual).isEqualTo(expected);
    }
}
