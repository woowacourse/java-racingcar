import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.controller.Input;

public class InputTest {
    public static final String TEST_REPEAT = "1";
    public static final String TEST_NAMES = "pobi,kafka";

    @DisplayName("이름 길이 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"pobipobi", "crongcrong", "honuxisgreat", ""})
    void 한명_입력시_이름길이_검증(String value) {
        Assertions.assertThatThrownBy(() -> {
            Input input = new Input(value, TEST_REPEAT);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching(Input.LENGTH_ERROR_MESSAGE);
    }

    @DisplayName("입력 split 테스트")
    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,honux:pobi", "a,b,c:c"}, delimiter = ':')
    void 여러명_입력시_split_검증(String value, String expected) {
        Input input = new Input(value, TEST_REPEAT);
        input.splitInputByComma().contains(expected);
    }

    @DisplayName("입력 split 후 이름 길이 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honuxs", "a,b,ccccccc", "a,,b", ""})
    void 여러명_입력시_이름길이_검증(String value) {
        Assertions.assertThatThrownBy(() -> {
            Input input = new Input(value, TEST_REPEAT);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching(Input.LENGTH_ERROR_MESSAGE);
    }

    @DisplayName("숫자 입력시 정수 타입 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"ABC", "2147483649"})
    void 횟수_입력시_타입_검증(String value) {
        Assertions.assertThatThrownBy(() -> {
            Input input = new Input(TEST_NAMES, value);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching(Input.NUMBER_FORMAT_ERROR_MESSAGE);
    }

    @DisplayName("숫자 입력시 양수가 아닌 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"-100", "0"})
    void 양이_아닌_정수_입력_테스트(String value) {
        Assertions.assertThatThrownBy(() -> {
            Input input = new Input(TEST_NAMES, value);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching(Input.NOT_POSITIVE_ERROR_MESSAGE);
    }
}