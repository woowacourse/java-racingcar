package racingcar.input.utils.carname.validators;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.input.utils.carname.validators.exceptions.InvalidCarNameFormatException;

public class CarNameFormatValidatorUtilsTest {

    @DisplayName("각 자동차 이름이 모두 1자 이상, 5자 이하의 숫자나 문자만으로 구성되어있으면 정상")
    @Test
    void allValidCarNames() {
        List<String> inputCarNames = new ArrayList<>();
        inputCarNames.add("aaa");
        inputCarNames.add("bbb1");
        inputCarNames.add("가나다1");
        inputCarNames.add("aaa1");
        assertThatCode(() -> CarNameFormatValidatorUtils.validateAllCarNamesFormat(inputCarNames))
            .doesNotThrowAnyException();
    }

    @DisplayName("5자 초과의 이름인 자동차가 있으면 예외 발생")
    @Test
    void invalidCarNamesWithMoreThanFiveLength() {
        List<String> inputCarNames = new ArrayList<>();
        inputCarNames.add("aaa");
        inputCarNames.add("bbb111");
        inputCarNames.add("가나다1");
        inputCarNames.add("aaa1");
        assertThatThrownBy(
            () -> CarNameFormatValidatorUtils.validateAllCarNamesFormat(inputCarNames))
            .isInstanceOf(InvalidCarNameFormatException.class);
    }

    @DisplayName("빈 문자열의 이름인 자동차가 있으면 예외 발생")
    @Test
    void invalidCarNamesWithBlank() {
        List<String> inputCarNames = new ArrayList<>();
        inputCarNames.add("aaa");
        inputCarNames.add("");
        inputCarNames.add("ccc");
        assertThatThrownBy(
            () -> CarNameFormatValidatorUtils.validateAllCarNamesFormat(inputCarNames))
            .isInstanceOf(InvalidCarNameFormatException.class);
    }

    @DisplayName("공백 문자가 포함되어있는 이름인 자동차가 있으면 예외 발생")
    @Test
    void invalidCarNamesWithSpaceCharacter() {
        List<String> inputCarNames = new ArrayList<>();
        inputCarNames.add("aaa");
        inputCarNames.add("b b");
        inputCarNames.add("ccc");
        assertThatThrownBy(
            () -> CarNameFormatValidatorUtils.validateAllCarNamesFormat(inputCarNames))
            .isInstanceOf(InvalidCarNameFormatException.class);
    }
}
