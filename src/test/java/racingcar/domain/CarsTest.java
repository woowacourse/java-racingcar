package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    void 자동차_2개_미만() {
        assertThatThrownBy(() -> Cars.withNames(List.of("rick")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차는 2대 이상 5대 이하이어야 합니다.");
    }

    @Test
    void 자동차_5개_초과() {
        assertThatThrownBy(
                () -> Cars.withNames(List.of("rick", "huni", "sudal", "ukong", "tomy", "pobi")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차는 2대 이상 5대 이하이어야 합니다.");
    }

    @DisplayName("자동차 이름 중복")
    @Test
    void carNamesDuplicated() {
        assertThatThrownBy(() -> Cars.withNames(List.of("rick", "rick", "huni")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름입니다.");
    }

    @DisplayName("자동차들을 모두 이동시킴")
    @Test
    void carsMoveForward() {
        Cars cars = Cars.withNames(List.of("rick", "huni", "pobi"));

        cars.moveCarsForward(() -> true);

        List<Integer> positions = cars.getCars().stream().map(Car::getPosition)
                .collect(Collectors.toList());
        assertThat(positions).containsExactly(1, 1, 1);
    }
}