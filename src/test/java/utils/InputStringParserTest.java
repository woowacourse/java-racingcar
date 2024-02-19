package utils;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputStringParserTest {

    @Test
    @DisplayName("입력 문자열 파싱 테스트")
    void parseInputToListTest() {
        List<String> names = InputStringParser.parseInputToList("재즈,호기,재즈다,호기다");

        Assertions.assertThat(names).isEqualTo(List.of("재즈", "호기", "재즈다", "호기다"));
    }

}
