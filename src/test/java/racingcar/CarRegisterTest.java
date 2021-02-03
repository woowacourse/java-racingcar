package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarRegisterTest {

    @DisplayName("경주할 자동차 이름 쉼표 단위 길이, 자동차 개수 등록 검사")
    @Test
     void splitInputCarNames() {
        String input = "pobi,crong,honux";
        Assertions.assertThat(CarRegister.registerCars(input).size()).isEqual(3);
    }

    @DisplayName("자동차 이름 길이 검사 - 예외")
    @Test
    void validateCarNameLengthException() {
        String input = "pobi,crong,honuxxxx";
        assertThatThrownBy(() -> {
            CarRegister.registerCars(input);
        }).isInstanceOf(InvalidCarNameLengthException.class);
    }

    @DisplayName("등록된 자동차 개수 검사")
    @Test
    void validateNumberOfRegisteredCars() {
        String input = ",,";
        assertThatThrownBy(() -> {
            CarRegister.registerCars(input);
        }).isInstanceOf(InvalidNumberOfRegisteredCarsException.class);
    }
}
