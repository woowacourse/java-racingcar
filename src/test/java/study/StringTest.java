package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringTest {
    @Test
    public void split() {
        String[] values = "1,2".split(",");
        assertThat(values).containsExactly("1", "2");
    }

    @Test
    public void bracket() {
        String value = "(1,2)".substring(1, 4);
        assertThat(value).isEqualTo("1,2");
    }

    @Test
    void bracketRemove() {
        String value = "(1,2)";
        value = value.replaceAll("[()]", "");
        assertThat(value).isEqualTo("1,2");
    }
    
}
