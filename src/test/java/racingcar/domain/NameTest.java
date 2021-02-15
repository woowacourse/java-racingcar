package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static racingcar.domain.Name.LENGTH_ERROR_MESSAGE;
import static racingcar.domain.Name.MAXIMUM_LENGTH;
import static racingcar.domain.Name.NULL_ERROR_MESSAGE;

class NameTest {
    @DisplayName("객체 생성 성공")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "brown", "json", "중간곰"})
    public void create_success(final String value) {
        assertThatCode(() -> new Name(value))
                .doesNotThrowAnyException();
    }

    @DisplayName("이름 길이가 길어 객체 생성 실패")
    @Test
    public void create_fail_long() {
        final String longName = new String(new char[MAXIMUM_LENGTH + 1]);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name(longName))
                .withMessageContaining(LENGTH_ERROR_MESSAGE);
    }

    @DisplayName("이름 길이가 짧아 객체 생성 실패")
    @Test
    public void create_fail_short() {
        final String shortName = "";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name(shortName))
                .withMessageContaining(LENGTH_ERROR_MESSAGE);
    }

    @DisplayName("이름의 값이 null이면 객체 생성 실패")
    @Test
    public void create_fail_null() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name(null))
                .withMessageContaining(NULL_ERROR_MESSAGE);
    }

    @DisplayName("동등 비교")
    @Test
    public void equals() {
        final String value = "중간곰";
        final Name name = new Name(value);

        assertThat(name)
                .isEqualTo(new Name(value));
    }
}