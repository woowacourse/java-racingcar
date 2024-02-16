package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    @Test
    @DisplayName("자동차 이름이 1자 이상 5자 이하가 아니면 예외가 발생한다.")
    void validateCarNamesFormatTest() {
        //given
        List<String> carNames = List.of("", "다섯글자초과");

        //when & then
        assertThrows(
                IllegalArgumentException.class,
                () -> Validator.validateCarNames(carNames),
                "자동차 이름은 1자 이상 5자 이하여야 합니다.");

    }

    @Test
    @DisplayName("자동차 이름이 중복되면 예외가 발생한다.")
    void validateDuplicatedNamesTest() {
        //given
        List<String> carNames = List.of("미아", "미아");

        //when & then
        assertThrows(
                IllegalArgumentException.class,
                () -> Validator.validateCarNames(carNames),
                "자동차 이름은 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("입력된 시도 횟수가 정수가 아니면 예외가 발생한다.")
    void validateIntegerTest() {
        //given
        String tryCount = "?";

        //when & then
        assertThrows(
                IllegalArgumentException.class,
                () -> Validator.validateInteger(tryCount),
                "시도 회수는 정수여야 합니다.");
    }

    @Test
    @DisplayName("입력된 시도 횟수가 양의 정수가 아니면 예외가 발생한다.")
    void validateTryCountTest() {
        //given
        int tryCount = -2;

        //when & then
        assertThrows(
                IllegalArgumentException.class,
                () -> Validator.validateTryCount(tryCount),
                "시도할 회수는 양의 정수여야 합니다.");
    }
}
