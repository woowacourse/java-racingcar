package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.input.utils.carname.exception.InvalidCarNameFormatException;
import racingcar.exception.InvalidDuplicateCarNameException;
import racingcar.exception.InvalidNumberOfRegisteredCarsException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarRegisterTest {

    private final CarRegister carRegister = new CarRegister();

    @DisplayName("경주할 자동차 이름 쉼표 단위 길이, 자동차 개수 등록 검사")
    @Test
     void splitInputCarNames() {
        String input = "pobi,crong,honux";
        Assertions.assertThat(carRegister.registerCars(input).size()).isEqualTo(3);
    }

    @DisplayName("자동차 이름 길이 검사 - 예외")
    @Test
    void validateCarNameLengthException() {
        String input = "pobi,crong,honuxxxx";
        assertThatThrownBy(() -> {
            carRegister.registerCars(input);
        }).isInstanceOf(InvalidCarNameFormatException.class);
    }

    @DisplayName("등록된 자동차 개수 검사")
    @Test
    void validateNumberOfRegisteredCars() {
        String input = ",,";
        assertThatThrownBy(() -> {
            carRegister.registerCars(input);
        }).isInstanceOf(InvalidNumberOfRegisteredCarsException.class);
    }

    @DisplayName("이름 중복 검사")
    @Test
    void validateDuplicateCarName() {
        String input = "pobi,pobi,crong";
        assertThatThrownBy(() -> {
            carRegister.registerCars(input);
        }).isInstanceOf(InvalidDuplicateCarNameException.class);
    }
}
