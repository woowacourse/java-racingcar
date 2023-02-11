package racingcar.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static racingcar.utils.SplitStringByComma.splitByComma;

public class SplitStringByCommaTest {
    @DisplayName("문자열을 콤마 기준으로 잘 분리하는지 테스트")
    @ParameterizedTest
    @MethodSource("stringDummy")
    void splitStringByCommaTest(String carNames, int expected) {
        Assertions.assertThat(splitByComma(carNames)).hasSize(expected);
    }

    static Stream<Arguments> stringDummy() {
        return Stream.of(
                Arguments.arguments("pobi, crong, honux", 3),
                Arguments.arguments("pobi,crong,,honux", 4),
                Arguments.arguments("pobi", 1)
        );
    }
}
