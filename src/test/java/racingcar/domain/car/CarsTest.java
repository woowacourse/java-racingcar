package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.movement.Movement;
import racingcar.domain.movement.NumberGenerator;
import racingcar.domain.movement.RandomNumberOverThanFour;
import racingcar.dto.CarDto;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {
    private final Cars cars = new Cars(Arrays.asList("abc", "def", "ghi"));
    private final int[] definedRandomNumberValues = {3, 4, 4};
    private int index = 0;
    private final NumberGenerator numberGenerator = (anyValue) -> definedRandomNumberValues[index++];
    private final Movement movement = new RandomNumberOverThanFour(numberGenerator);

    @Test
    @DisplayName("자동차 이름 간 중복이 있을 경우 예외를 발생시킵니다.")
    void create_duplicatedCarNames_Test() {
        //given
        List<String> duplicatedCarNames = Arrays.asList("a", "a", "b");
        String expectedExceptionMessage = "자동차 이름들 간 중복이 있습니다.";
        //when, then
        assertThatThrownBy(() -> new Cars(duplicatedCarNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedExceptionMessage);
    }

    @Test
    @DisplayName("자동차들을 전진(혹은 정지)시키고 반환한다")
    void move_getCars_Test() {
        //given
        cars.move(movement);
        final CarDto abc = new CarDto("abc", 0);
        final CarDto def = new CarDto("def", 1);
        final CarDto ghi = new CarDto("ghi", 1);
        final List<CarDto> expected = Arrays.asList(abc, def, ghi);
        //when
        final List<CarDto> movedCar = cars.getCarInfos();
        //then
        assertThat(movedCar).isEqualTo(expected);
    }

    @Test
    @DisplayName("가장 멀리 간 자동차들을 반환한다.")
    void getFarthestCar_Test() {
        //given
        cars.move(movement);
        final CarDto def = new CarDto("def", 1);
        final CarDto ghi = new CarDto("ghi", 1);
        final List<CarDto> expected = Arrays.asList(def, ghi);
        //when
        final List<CarDto> actual = cars.getFarthestCar();
        //then
        assertThat(actual).isEqualTo(expected);
    }
}