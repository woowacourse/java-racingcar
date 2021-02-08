package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarsTest {

    @ParameterizedTest
    @DisplayName("생성 성공 - 올바른 입력")
    @ValueSource(strings = {"pobi,joy,poz", "pobi,joy , poz"})
    void from_valid(String input) {
        assertThat(Cars.of(input, new FixedNumberGeneratingStrategy()).getCars())
                .containsExactly(
                        Car.from("pobi"),
                        Car.from("joy"),
                        Car.from("poz"));
    }

    @ParameterizedTest
    @DisplayName("생성 실패 - (,)중복")
    @ValueSource(strings = {"aa,,bb"})
    void from_invalid(String input) {
        assertThatThrownBy(() -> Cars.of(input, new FixedNumberGeneratingStrategy()).getCars())
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("생성 실패 - Car 이름 중복")
    void from_duplicatedName() {
        assertThatThrownBy(() -> Cars.of("joy,joy", new FixedNumberGeneratingStrategy()).getCars())
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void driveAll() {
        Cars cars = Cars.of("joy, poz", new FixedNumberGeneratingStrategy());
        cars.driveAll();

        cars.getCars().forEach(car -> assertThat(car.getPosition()).isEqualTo(2));
    }
}
