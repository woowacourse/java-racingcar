package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ParserTest {

    @Test
    @DisplayName("구분자를 통해 문자열을 분리한다")
    public void parseWithDelimiter() {
        String names = "kong,gray,echo";
        String kong = "kong";
        String gray = "gray";
        String echo = "echo";
        String delimiter = ",";

        assertThat(Parser.parse(names, delimiter)).containsExactly(kong, gray, echo);
    }
}
