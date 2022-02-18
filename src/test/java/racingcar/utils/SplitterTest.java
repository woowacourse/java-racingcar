package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitterTest {
    @Test
    @DisplayName("입력 받은 문자열을 ,로 나눈 후, 공백을 지워 문자열 배열로 반환한다.")
    void split() {
        String input = "  범고래,  소주캉";
        List<String> expected = Arrays.asList("범고래", "소주캉");
        assertThat(Splitter.split(input)).isEqualTo(expected);
    }
}
