package racingcar.input.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.InvalidCarNameException;

public class CarNameFormatValidatorUtilsTest {

    @DisplayName("각 자동차 이름이 모두 1자 이상, 5자 이하의 숫자나 문자만으로 구성되어있으면 true 반환")
    @Test
    void allValidCarNames() {
        List<String> inputCarNames = new ArrayList<>();
        inputCarNames.add("aaa");
        inputCarNames.add("bbb1");
        inputCarNames.add("가나다1");
        inputCarNames.add("aaa1");
        assertDoesNotThrow(() -> CarNameFormatValidatorUtils.isAllValidCarNames(inputCarNames));
    }

    @DisplayName("5자 초과의 이름인 자동차가 있으면 false 반환")
    @Test
    void invalidCarNamesWithMoreThanFiveLength() {
        List<String> inputCarNames = new ArrayList<>();
        inputCarNames.add("aaa");
        inputCarNames.add("bbb111");
        inputCarNames.add("가나다1");
        inputCarNames.add("aaa1");
        assertThrows(InvalidCarNameException.class,
            () -> CarNameFormatValidatorUtils.isAllValidCarNames(inputCarNames));
    }

    @DisplayName("빈 문자열의 이름인 자동차가 있으면 false 반환")
    @Test
    void invalidCarNamesWithBlank() {
        List<String> inputCarNames = new ArrayList<>();
        inputCarNames.add("aaa");
        inputCarNames.add("");
        inputCarNames.add("ccc");
        assertThrows(InvalidCarNameException.class,
            () -> CarNameFormatValidatorUtils.isAllValidCarNames(inputCarNames));
    }

    @DisplayName("공백 문자가 포함되어있는 이름인 자동차가 있으면 false 반환")
    @Test
    void invalidCarNamesWithSpaceCharacter() {
        List<String> inputCarNames = new ArrayList<>();
        inputCarNames.add("aaa");
        inputCarNames.add("b b");
        inputCarNames.add("ccc");
        assertThrows(InvalidCarNameException.class,
            () -> CarNameFormatValidatorUtils.isAllValidCarNames(inputCarNames));
    }
}
