package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class NameTest {

    @Test
    public void validateNameLength() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Name("ABCDEF");
        });
        assertThat(exception.getMessage()).contains("[ERROR]");
    }
}
