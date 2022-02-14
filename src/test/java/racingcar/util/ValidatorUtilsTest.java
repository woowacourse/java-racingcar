package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

import static common.DisplayFormat.PARAMETERIZED_TEST_DISPLAY_FORMAT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static racingcar.util.ValidatorUtils.validateAndParsePositiveInt;
import static racingcar.util.ValidatorUtils.validateNoDuplicateCar;
import static racingcar.util.ValidatorUtils.validateNotBlank;
import static racingcar.util.ValidatorUtils.validateNotOverFiveCharacters;

public class ValidatorUtilsTest {

    @DisplayName("validateAndParsePositiveInt 메서드는 문자열을 양수로 변환하여 반환한다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @ValueSource(strings = {"1", "2", "10"})
    void validateAndParsePositiveInt_returnParsedPositiveInteger(String string) {
        int parsedInt = validateAndParsePositiveInt(string);

        assertThat(parsedInt).isPositive();
    }

    @DisplayName("validateAndParsePositiveInt 메서드는 양수 이외의 문자열이 입력되었을 때 예외를 발생시킨다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @ValueSource(strings = {"한글", "eng", "$", "1.0"})
    void validateAndParsePositiveInt_errorOnNonInteger(String string) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> validateAndParsePositiveInt(string));
    }

    @DisplayName("validateAndParsePositiveInt 메서드는 음수 혹은 0에 해당되는 문자열이 입력되었을 때 예외를 발생시킨다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @ValueSource(strings = {"-1", "0"})
    void validateAndParsePositiveInt_errorOnNonPositiveInteger(String string) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> validateAndParsePositiveInt(string));
    }

    @DisplayName("validateNotBlank 메서드는 공백이 포함되었더라도 문자가 존재하는 경우 예외를 발생시키지 않는다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @ValueSource(strings = {"a", "b  ", "  c "})
    void validateNotBlank_passOnNotBlank(String string) {
        assertThatNoException()
                .isThrownBy(() -> validateNotBlank(string));
    }

    @DisplayName("validateNotBlank 메서드는 공백 혹은 빈 문자열이 입력되었을 때 예외를 발생시킨다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @ValueSource(strings = {"", "   "})
    void validateNotBlank_errorOnBlank(String string) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> validateNotBlank(string));
    }

    @DisplayName("validateNotOverFiveCharacters 메서드는 5글자 이내의 문자열이 입력되었을 때 예외를 발생시키지 않는다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @ValueSource(strings = {"a", "bc", "bacon"})
    void validateNotOverFiveCharacters_passOnFiveOrLess(String string) {
        assertThatNoException()
                .isThrownBy(() -> validateNotOverFiveCharacters(string));
    }

    @DisplayName("splitAndValidateCarNames 메서드는 5글자를 초과하는 문자열이 입력되었을 때 예외를 발생시킨다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @ValueSource(strings = {"123456", "carrots"})
    void validateNotOverFiveCharacters_errorOnOverFive(String string) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> validateNotOverFiveCharacters(string));
    }

    @DisplayName("validateNoDuplicateCar 메서드는 배열 인자가 서로 이름이 다른 Car 인스턴스들만으로 구성될 경우 예외를 발생시키지 않는다.")
    @Test
    void validateNoDuplicateCar_passOnNoDuplicates() {
        List<Car> carList = new ArrayList<>();

        carList.add(new Car("ace"));
        carList.add(new Car("pobi"));
        carList.add(new Car("jeong"));

        assertThatNoException()
                .isThrownBy(() -> validateNoDuplicateCar(carList));
    }

    @DisplayName("validateNoDuplicateCar 메서드는 배열 인자로 이름이 동일한 Car 인스턴스가 포함된 경우 예외를 발생시킨다.")
    @Test
    void validateNoDuplicateCar_errorOnDuplicates() {
        List<Car> carList = new ArrayList<>();

        carList.add(new Car("ace"));
        carList.add(new Car("ace"));
        carList.add(new Car("jeong"));

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> validateNoDuplicateCar(carList));
    }
}
