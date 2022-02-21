package racingcar.utils;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.utils.validator.TrialNumberValidator;

public class TrialNumberValidatorTest {
    @ParameterizedTest(name = "{index}: {1}")
    @MethodSource("invalidParameters")
    @DisplayName("시도횟수 입력 유효성 검사")
    void 시도횟수_입력_유효성_검사(String trialNumber, String testName) {
        assertThatThrownBy(() -> TrialNumberValidator.validate(trialNumber))
            .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> invalidParameters() {
        return Stream.of(
            Arguments.of("", "빈 문자"),
            Arguments.of(null, "널 입력"),
            Arguments.of("0", "0 입력"),
            Arguments.of("-1", "음수 입력"),
            Arguments.of("a", "문자입력: a"),
            Arguments.of("*", "문자입력: *"),
            Arguments.of("1.3", "소수입력")
        );
    }
}
