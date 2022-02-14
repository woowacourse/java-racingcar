package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static racingcar.constants.output.ErrorOutputMessages.ERROR_NULL;

class SplitUtilsTest {

    @DisplayName("splitByComma는 문자열을 쉼표 구분자로 구분한 뒤 문자열 배열을 반환한다.")
    @Test
    void splitByComma() {
        String[] names = SplitUtils.splitByComma("jeong,pobi,roma");

        assertThat(names).containsExactly("jeong", "pobi", "roma");
    }

    @DisplayName("splitByComma는 null이 입력되었을 때 예외를 발생한다.")
    @Test
    void splitByComma_errorOnNull() {
        assertThatExceptionOfType(NullPointerException.class)
            .isThrownBy(() -> SplitUtils.splitByComma(null))
            .withMessageMatching(ERROR_NULL);
    }
}
