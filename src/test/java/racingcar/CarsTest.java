package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
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
    void makeCar_valid(String input) {
        assertThat(Cars.makeCar(input).getCars())
                .containsExactly(
                        new Car("pobi"),
                        new Car("joy"),
                        new Car("poz"));
    }

    @ParameterizedTest
    @DisplayName("Car들이 올바르지 않게 생성")
    @ValueSource(strings = {"aa,,bb"})
    void makeCar_invalid(String input) {
        assertThatThrownBy(() -> {
            Cars.makeCar(input).getCars();
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("Car 이름 중복")
    void makeCar_duplicatedName() {
        assertThatThrownBy(() -> {
            Cars.makeCar("joy,joy").getCars();
        }).isInstanceOf(RuntimeException.class);
    }

    private static Stream<Arguments> provideInvalidCarsNameString() {
        return Stream.of(
                Arguments.of("pobi,joy,poz",
                        Arrays.asList(new Car("pobi"), new Car("joy"), new Car("poz")))
        );
    }
}
