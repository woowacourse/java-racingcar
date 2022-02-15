package racingcar.model.value;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"123456"})
    @DisplayName("공백 또는 5자가 넘어가는 이름은 생성할 수 없다")
    void failCreateName(String input) {
        // then
        assertThatThrownBy(() -> new Name(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
