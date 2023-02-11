package racingcar.view.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.ErrorMessage;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarNamesRequestTest {

    @DisplayName("구분자만 입력 할 수 없습니다.")
    @Test
    void validateEmptyCarName() {
        String testSampleValue = ",,,";
        createFailureTest(testSampleValue, ErrorMessage.CAR_NAME_NULL.message());
    }

    @DisplayName("자동차 이름에는 문자와 숫자만 들어갈 수 있습니다.")
    @ParameterizedTest
    @ValueSource(strings = {"a,ba, ,abs", ",a,b", "a c v"})
    void validateFormatTest(String input) {
        createFailureTest(input, ErrorMessage.INVALID_CAR_NAME_FORMAT.message());
    }

    @DisplayName("자동차 이름은 한글자 이상이어야 합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"  ", "car1,,car2", ""})
    void validateBlankTest(String input) {
        createFailureTest(input, ErrorMessage.INVALID_CAR_NAME_FORMAT.message());
    }

    @DisplayName("자동차 이름은 다섯글자 이하이어야 합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "car,carscar"})
    void validateOverLengthTest(String input) {
        createFailureTest(input, ErrorMessage.CAR_NAME_OVER_RANGE.message());
    }

    @DisplayName("자동차 이름은 중복될 수 없습니다.")
    @Test
    void validateDuplication() {
        String testSampleValue = "pobi,crong,pobi";
        createFailureTest(testSampleValue, ErrorMessage.CAR_NAME_DUPLICATED.message());
    }

    @DisplayName("정상적인 형식의 자동차 이름으로 생성되어야 합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong", "royce,logan", "abc"})
    void generateCarNamesTest(String input) {
        assertThatCode(() -> {
            new CarNamesRequest(input);
        }).doesNotThrowAnyException();
    }

    private void createFailureTest(String testSampleValue, String expectedErrorMessage) {
        assertThatCode(() -> {
            new CarNamesRequest(testSampleValue);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedErrorMessage);
    }

    @DisplayName("자동차 이름 저장 테스트")
    @Test
    void saveCarNameTest() {
        // given
        String testInputValue = "pobi,crong";

        // when
        CarNamesRequest carNamesRequest = new CarNamesRequest(testInputValue);
        List<String> carNameList = carNamesRequest.toSplitCarNames();

        // then
        assertThat(carNameList.get(0)).isEqualTo("pobi");
        assertThat(carNameList.get(1)).isEqualTo("crong");
    }
}
