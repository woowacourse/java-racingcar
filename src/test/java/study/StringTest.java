package study;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    public void splitAndSum_comma() {
        String[] values = "1,2".split(",");
        assertThat(values).containsExactly("1", "2");
    }

    @Test
    public void splitAndSum_single() {
        String[] values = "1".split(",");
        assertThat(values).contains("1");
    }
}
