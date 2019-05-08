package util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringUtilsTest {
    @Test
    void parseStringByComma() {
        List<String> answer = Arrays.asList("a", "b", "c");
        assertThat(StringUtils.parseStringByComma("a,b,c")).isEqualTo(answer);
    }
}
