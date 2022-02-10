package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.service.Movement;
import racingcar.utils.ExceptionMessage;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


class CarsTest {

    private Cars cars = new Cars(Arrays.asList("abc", "def", "ghi"));
    private boolean[] definedMovement = {false, true, false};
    private int index = 0;
    private Movement movement = () -> definedMovement[index++];

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
        cars.move(movement);
        List<Car> movedCar = cars.getCars();
        Car abc = new Car("abc");
        Car def = new Car("def");
        Car ghi = new Car("ghi");
        def.move(true);
        List<Car> expected = Arrays.asList(abc, def, ghi);
        assertThat(movedCar).isEqualTo(expected);
    }

}