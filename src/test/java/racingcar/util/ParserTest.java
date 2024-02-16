package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.util.Parser.parseCarNames;

class ParserTest {
    @Test
    @DisplayName("입력된 자동차 이름 문자열을 ,로 파싱하고, 양옆 공백을 제거한다.")
    void parseCarNamesTest() {
        //given
        String carNamesInput = "미아, 메이슨, 포비   ";

        //when
        List<String> parsedCarNames = parseCarNames(carNamesInput);

        //then
        assertThat(parsedCarNames).containsExactly("미아", "메이슨", "포비");
    }
}
