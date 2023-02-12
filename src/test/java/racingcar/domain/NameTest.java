package racingcar.domain;

import static java.text.MessageFormat.format;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {

    @ParameterizedTest(name = "이름: {0}")
    @ValueSource(strings = {"dazzle", ""})
    @DisplayName("생성자는 이름의 길이가 없거나 5보다 크다면 예외를 던진다.")
    void should_throwException_when_invalidNameLength(final String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(format("입력된 차 이름[{0}]: 차의 이름은 1자 이상 ~ 5자 이하여야 합니다.", name));
    }
}
