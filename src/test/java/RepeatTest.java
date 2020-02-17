import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.domain.Repeat;

public class RepeatTest {
    @DisplayName("숫자 입력시 정수 타입 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"ABC", "2147483649"})
    void 횟수_입력시_타입_검증(String value) {
        Assertions.assertThatThrownBy(() -> {
            Repeat repeat = new Repeat(value);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching(Repeat.NUMBER_FORMAT_ERROR_MESSAGE);
    }

    @DisplayName("숫자 입력시 양수가 아닌 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"-100", "0"})
    void 양이_아닌_정수_입력_테스트(String value) {
        Assertions.assertThatThrownBy(() -> {
            Repeat repeat = new Repeat(value);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching(Repeat.NOT_POSITIVE_ERROR_MESSAGE);
    }
}
