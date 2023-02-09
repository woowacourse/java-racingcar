package racingcar.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarNameTest {
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"123456"})
    void 생성시_잘못된_데이터가_들어오면_IEA_예외가_발생한다(String input) {
        assertThatThrownBy(() -> new CarName(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 생성시_5이하의_길이가_들어오면_잘_생성됨() {
        assertDoesNotThrow(() -> new CarName("12345"));
    }
}
