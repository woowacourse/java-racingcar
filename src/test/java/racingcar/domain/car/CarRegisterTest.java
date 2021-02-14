package racingcar.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.InvalidCarNameLengthException;
import racingcar.exception.InvalidDuplicateCarNameException;
import racingcar.exception.InvalidNumberOfRegisteredCarsException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarRegisterTest {

    @DisplayName("경주할 자동차 이름 쉼표 단위 길이, 자동차 개수 등록 검사")
    @Test
     void splitInputCarNames() {
        String input = "pobi,crong,honux";
        Assertions.assertThat(CarRegister.splitCarNames(input).size()).isEqualTo(3);
    }

    @DisplayName("등록된 자동차 개수 검사")
    @Test
    void validateNumberOfRegisteredCars() {
        String input = ",,";
        assertThatThrownBy(() -> {
            CarRegister.splitCarNames(input);
        }).isInstanceOf(InvalidNumberOfRegisteredCarsException.class);
    }

    @DisplayName("이름 중복 검사")
    @Test
    void validateDuplicateCarName() {
        String input = "pobi,pobi,crong";
        assertThatThrownBy(() -> {
            CarRegister.splitCarNames(input);
        }).isInstanceOf(InvalidDuplicateCarNameException.class);
    }
}
