package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameTest {

    @DisplayName("이름의 길이가 5자를 초과할 경우 예외를 반환합니다.")
    @Test
    public void validateNameLength() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Name("ABCDEF");
        });
        assertThat(exception.getMessage()).contains("[ERROR]");
    }
}
