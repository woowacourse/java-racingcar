package racingcar.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.*;

public class NameTest {
    @ParameterizedTest
    @CsvSource(value = {" pobi:pobi", "hoho :hoho", " rich :rich"}, delimiter = ':')
    @DisplayName("이름 앞 뒤에 공백이 존재하면 제거한다")
    void removeWhitespaces(String actual, String expected) {
        assertThat(Name.create(actual)).isEqualTo(Name.create(expected));
    }

    @ParameterizedTest
    @ValueSource(strings = "hohoho")
    @DisplayName("이름이 5글자가 넘으면 예외 발생 테스트")
    void nameLengthShouldBeLessThenSix(String actual) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> Name.create(actual))
            .withMessageMatching("이름은 \\d+글자가 넘을 수 없습니다. :\\d+");
    }
}
