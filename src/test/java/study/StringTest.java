package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringTest {
    @Test
    void split() {
        String[] values ="1,2".split(",");
        assertThat(values[0]).isEqualTo("1");
        assertThat(values[1]).isEqualTo("2");
        assertThat(values).containsExactly("1", "2");
    }
}