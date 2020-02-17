import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.domain.Names;
import racinggame.domain.Repeat;

import java.util.List;

public class NamesTest {
    @DisplayName("이름 길이 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"pobipobi", "crongcrong", "honuxisgreat", ""})
    void 한명_입력시_이름길이_검증(String value) {
        Assertions.assertThatThrownBy(() -> {
            Names input = new Names(value);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching(Names.LENGTH_ERROR_MESSAGE);
    }

    @DisplayName("입력 split 테스트")
    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,honux:pobi:crong:honux", "a,b,c:a:b:c"},
            delimiter = ':')
    void 여러명_입력시_split_검증(String value, String expected1, String expected2,
                          String expected3) {
        List<String> splitNames = Names.splitInputByComma(value);
        Assertions.assertThat(splitNames.contains(expected1)).isTrue();
        Assertions.assertThat(splitNames.contains(expected2)).isTrue();
        Assertions.assertThat(splitNames.contains(expected3)).isTrue();
    }

    @DisplayName("입력 split 후 이름 길이 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honuxs", "a,b,ccccccc", "a,,b", ""})
    void 여러명_입력시_이름길이_검증(String value) {
        Assertions.assertThatThrownBy(() -> {
            Names input = new Names(value);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching(Names.LENGTH_ERROR_MESSAGE);
    }
}