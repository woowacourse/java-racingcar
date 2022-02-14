package racingcar.utils;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

class NameValidatorTest {

    @ParameterizedTest(name = "{index}: {1}")
    @MethodSource("invalidParameters")
    @DisplayName("car 이름 생성 유효성 검사")
    void invalidCreate(String carNames, String testName) {
        assertThatThrownBy(() -> NameValidator.isValidateNames(carNames))
            .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> invalidParameters() {
        return Stream.of(
            Arguments.of("", "빈 문자 입력"),
            Arguments.of("pobi,", "한글자 미만"),
            Arguments.of("pobi,donghok", "5글자 초과")
        );
    }

    @Test
    void 자동차이름_1개() {
        assertThatCode(() -> NameValidator.isValidateNames("pobi"))
                .doesNotThrowAnyException();
    }

    @Test
    void 자동차이름_중복() {
        assertThatThrownBy(() -> NameValidator.isDuplicatedNames(Arrays.asList("pobi","pobi")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
