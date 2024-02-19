package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    @Test
    @DisplayName("빈 문자열이 자동차 이름 문자열로 입력된다면 예외가 발생한다.")
    public void validateEmptyCarNamesTest() {
        //given
        String carNames = "";

        //when & then
        assertThrows(
                IllegalArgumentException.class,
                () -> Validator.validateEmptyCarNames(carNames),
                "자동차 이름 목록을 입력해주세요.");
    }

    @Test
    @DisplayName("자동차 이름이 1자 이상 5자 이하가 아니면 예외가 발생한다.")
    void validateCarNamesFormatLengthTest() {
        //given
        List<String> carNames = List.of("", "moreThanLimit");

        //when & then
        assertThrows(
                IllegalArgumentException.class,
                () -> Validator.validateCarNames(carNames),
                "자동차 이름은 1자 이상 5자 이하여야 합니다.");

    }

    @Test
    @DisplayName("자동차 이름이 영문 알파벳이 아니면 예외가 발생한다.")
    void validateCarNamesFormatAlphabetTest() {
        //given
        List<String> carNames = List.of("Mason", "메이슨");

        //when & then
        assertThrows(
                IllegalArgumentException.class,
                () -> Validator.validateCarNames(carNames),
                "자동차 이름은 알파벳 대소문자로만 구성되어야 합니다.");
    }

    @Test
    @DisplayName("자동차 이름이 중복되면 예외가 발생한다.")
    void validateDuplicatedNamesTest() {
        //given
        List<String> carNames = List.of("Mia", "Mia");

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
                () -> Validator.validateTryCount(tryCount),
                "시도 회수는 정수여야 합니다.");
    }

    @Test
    @DisplayName("입력된 시도 횟수가 양의 정수가 아니면 예외가 발생한다.")
    void validatePositiveIntegerTest() {
        //given
        String tryCount = "-2";

        //when & then
        assertThrows(
                IllegalArgumentException.class,
                () -> Validator.validateTryCount(tryCount),
                "시도할 회수는 양의 정수여야 합니다.");
    }

    @Test
    @DisplayName("입력된 시도 횟수가 양의 정수가 아니면 예외가 발생한다.")
    void validateMaxTryCountTest() {
        //given
        String tryCount = "51";

        //when & then
        assertThrows(
                IllegalArgumentException.class,
                () -> Validator.validateTryCount(tryCount),
                "시도할 회수는 양의 정수여야 합니다.");
    }
}