package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    public void splitString() {
        assertThat("1,2".split(",")).containsExactly("1", "2");
    }
}
