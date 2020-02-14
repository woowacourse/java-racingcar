package racingCar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class NameParserTest {
    @Test
    @DisplayName("사용자의 이름을 쉼표 기준으로 구분한다")
    void parse() throws Exception {
        String input = "pobi,jason";
        List<String> expected = Arrays.asList(new String[]{"pobi", "jason"});
        List<String> result = NameParser.parse(input);

        Assertions.assertThat(result.equals(expected)).isTrue();
    }
}
