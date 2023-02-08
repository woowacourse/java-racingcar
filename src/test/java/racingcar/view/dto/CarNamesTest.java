package racingcar.view.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarNamesTest {
    @DisplayName("자동차 이름에는 문자와 숫자만 들어갈 수 있습니다.")
    @ParameterizedTest
    @ValueSource(strings = {"a,ba, ,abs", ",a,b", "a c v"})
    void validateFormatTest(String input) {
        assertThatThrownBy(() -> {
            new CarNames(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름은 한글자 이상이어야 합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"  ", "car1,,car2", ""})
    void validateBlankTest(String input) {
        assertThatThrownBy(() -> {
            new CarNames(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름은 다섯글자 이하이어야 합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "car,carscar"})
    void validateOverLengthTest(String input) {
        assertThatThrownBy(() -> {
            new CarNames(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름은 중복될 수 없습니다.")
    @Test
    void validateDuplication() {
        String testSampleValue = "pobi,crong,pobi";

        assertThatCode(() -> {
            new CarNames(testSampleValue);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상적인 형식의 자동차 이름으로 생성되어야 합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong", "royce,logan", "abc"})
    void generateCarNamesTest(String input) {
        assertThatCode(() -> {
            new CarNames(input);
        }).doesNotThrowAnyException();
    }

    @DisplayName("자동차 이름 저장 테스트")
    @Test
    void saveCarNameTest() {
        // given
        String testInputValue = "pobi,crong";


        // when
        CarNames carNames = new CarNames(testInputValue);
        List<String> carNameList = carNames.toCarNameList();

        // then
        assertThat(carNameList.get(0)).isEqualTo("pobi");
        assertThat(carNameList.get(1)).isEqualTo("crong");
    }
}