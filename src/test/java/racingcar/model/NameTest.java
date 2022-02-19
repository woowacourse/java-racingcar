package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameTest {

    @DisplayName("이름의 길이가 5자를 초과할 경우 예외를 반환합니다.")
    @Test
    public void validateNameLength_max_5() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Name("ABCDEF");
        });
        assertThat(exception.getMessage()).contains("[ERROR]");
    }

    @DisplayName("이름의 길이가 1자 이상인지 테스트합니다.")
    @Test
    public void validateNameLength_longer_than_zero() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Name("");
        });
        assertThat(exception.getMessage()).contains("[ERROR]");
    }

    @DisplayName("이름은 null이 아닌지 테스트합니다.")
    @Test
    public void validateNameLength_not_null() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Name(null);
        });
        assertThat(exception.getMessage()).contains("[ERROR]");
    }
}
