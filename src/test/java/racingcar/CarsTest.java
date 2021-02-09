package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car.Car;
import racingcar.domain.Cars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @ParameterizedTest
    @DisplayName("CarName Input이 올바른 이름들로만 주어질 때의 테스트")
    @ValueSource(strings = {"pobi,joy,poz", "pobi,joy , poz"})
    void from_valid(String input) {
        assertThat(Cars.from(input).getCars())
                .containsExactly(
                        new Car("pobi"),
                        new Car("joy"),
                        new Car("poz"));
    }

    @ParameterizedTest
    @DisplayName("CarName Input에서 빈 문자열이 들어있어 올바르지 않게 생성 테스트")
    @ValueSource(strings = {"aa,,bb"})
    void from_invalid(String input) {
        assertThatThrownBy(() -> {
            Cars.from(input).getCars();
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("CarName Input에서 중복된 이름이 있을 때의 테스트")
    void from_duplicatedName() {
        assertThatThrownBy(() -> {
            Cars.from("joy,joy").getCars();
        }).isInstanceOf(RuntimeException.class);
    }
}