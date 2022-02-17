package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {
    @Test
    @DisplayName("Name 정상 생성")
    public void success() {
        // when
        Name name = new Name("test");

        // then
        assertThat(name).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "1231456"})
    @DisplayName("Name 생성 실패")
    public void failed(String string) {
        // then
        assertThatThrownBy(() -> new Name(string)).isInstanceOf(IllegalArgumentException.class);
    }
}