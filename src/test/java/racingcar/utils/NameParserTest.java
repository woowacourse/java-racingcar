package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameParserTest {
    @Test
    @DisplayName("입력받은 이름들을 구분자 단위로 구분한다.")
    void parseTest() {
        String rawNames = "abc,def,zzz";
        List<String> parsedNames = NameParser.parse(rawNames);

        assertThat(parsedNames).isEqualTo(List.of("abc", "def", "zzz"));
    }
}
