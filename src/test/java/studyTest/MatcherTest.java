package studyTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MatcherTest {

    @DisplayName("Matcher group(0) 학습 테스트")
    @Test
    public void group_null_test() throws Exception {
        String input = "//;\n1;2;3";
        Pattern pattern = Pattern.compile("//(.)\n(.*)");
        Matcher matcher = pattern.matcher(input);
        String blank = "";
        String first = "";
        if (matcher.find()) {
            blank = matcher.group();
            first = matcher.group(0);
        }
        assertThat(blank).isEqualTo(first);
    }

    @DisplayName("Matcher group(1) 학습 테스트")
    @Test
    public void group_1_test() throws Exception {
        String input = "//;\n1;2;3";
        Pattern pattern = Pattern.compile("//(.)\n(.*)");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            assertThat(matcher.group(1)).isEqualTo(";");
        }
    }
}
