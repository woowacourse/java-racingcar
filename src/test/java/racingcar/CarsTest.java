package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarsTest {

    String carsName;

    @BeforeEach
    void setUp() {
        carsName = "pobi,crong,joy,poz";
    }

    @ParameterizedTest
    @DisplayName("Car들이 올바르게 생성")
    @ValueSource(strings = {"pobi,joy,poz", "pobi,joy , poz"})
    void from_valid(String input) {
        assertThat(Cars.from(input).getCars())
                .containsExactly(
                        Car.from("pobi"),
                        Car.from("joy"),
                        Car.from("poz"));
    }

    @ParameterizedTest
    @DisplayName("Car들이 올바르지 않게 생성")
    @ValueSource(strings = {"aa,,bb"})
    void from_invalid(String input) {
        assertThatThrownBy(() -> {
            Cars.from(input).getCars();
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("Car 이름 중복")
    void from_duplicatedName() {
        assertThatThrownBy(() -> {
            Cars.from("joy,joy").getCars();
        }).isInstanceOf(RuntimeException.class);
    }
}
