package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.Validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class ValidationUtilTest {
    @Test
    @DisplayName("자동차의 이름의 길이가 6자 이상인 경우 예외를 발생시킨다")
    void shouldThrowExceptionWhenNameLengthOverSix() {
        String nameString = "pobi,jason11";

        assertThatThrownBy(() -> Validator.checkEachName(nameString))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("이하");
    }

    @Test
    @DisplayName("자동차의 이름의 길이가 1보다 작은 경우 예외를 발생시킨다")
    void shouldThrowExceptionWhenNameLengthLessThanOne() {
        String nameString = "pobi,,jason";
        assertThatThrownBy(() -> Validator.checkEachName(nameString))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("이상");
    }

    @Test
    @DisplayName("입력값으로 빈 문자열이 들어온 경우 예외를 발생시킨다")
    void shouldThrowExceptionWhenInputStringIsBlank() {
        String nameString = "";
        assertThatThrownBy(() -> Validator.checkNameStringFormat(nameString))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("이상");

    }

    @Test
    @DisplayName("입력값에 쉼표만 있는 경우 예외를 발생시킨다")
    void shouldThrowExceptionWhenInputStringContainsOnlyComma() {
        String nameString = ",,";

        assertThatThrownBy(() -> Validator.checkNameStringFormat(nameString))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("이름을 입력해주세요");

    }

    @Test
    @DisplayName("입력값에 포함된 이름이 중복된 경우 예외를 발생시킨다")
    void shouldThrowExceptionWhenContainsDuplicateName() {
        String nameString = "pobi,pobi";

        assertThatThrownBy(() -> Validator.checkNameStringFormat(nameString))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("중복");
    }

    @Test
    @DisplayName("참가하는 자동차가 하나인 경우 예외를 발생시킨다")
    void shouldThrowExceptionWhenSinglePlayer() {
        String nameString = "pobi";

        assertThatThrownBy(() -> Validator.checkNameStringFormat(nameString))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("최소");
    }

    @Test
    @DisplayName("시도 횟수의 입력값이 숫자가 아닌 경우 예외를 발생시킨다")
    void shouldThrowExceptionWhenCountInputIsNotANumber() {
        String countString = "a";

        assertThatThrownBy(() -> Validator.checkCount(countString))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("숫자");
    }

    @Test
    @DisplayName("시도 횟수의 입력값이 1보다 작은 경우 예외를 발생시킨다")
    void shouldThrowExceptionWhenCountLessThanOne() {
        String countString = "0";

        assertThatThrownBy(() -> Validator.checkCount(countString))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("1 이상");
    }

    @Test
    @DisplayName("시도 횟수의 입력값이 50을 넘는 경우 예외를 발생시킨다")
    void shouldThrowExceptionWhenCountOverFifty() {
        String countString = "51";

        assertThatThrownBy(() -> Validator.checkCount(countString))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("50 이하");
    }
}
