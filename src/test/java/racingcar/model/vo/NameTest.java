package racingcar.model.vo;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NameTest {
    @ParameterizedTest
    @CsvSource(value = {" pobi:pobi", "hoho :hoho", " rich :rich"}, delimiter = ':')
    @DisplayName("이름 앞 뒤에 공백이 존재하면 제거한다")
    void removeWhitespaces(String actual, String expected) {
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("이름이 5글자가 넘으면 예외 발생 테스트")
    void nameLengthShouldBeLessThenSix() {
        String overSizedName = "richard";

        assertThatThrownBy(() -> new Car(overSizedName))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageMatching("이름은 \\d+글자가 넘을 수 없습니다.");
    }
}
