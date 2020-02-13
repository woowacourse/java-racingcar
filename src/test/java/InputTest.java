import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingGame.controller.Input;

public class InputTest {

    public static final String TEST_REPEAT = "1";
    public static final String TEST_NAMES = "pobi,kafka";

    @ParameterizedTest
    @ValueSource(strings = {"pobipobi", "crongcrong", "honuxisgreat", ""})
    void 한명_입력시_이름길이_검증(String value) {
        Assertions.assertThatThrownBy(() -> {
            Input input = new Input(value,TEST_REPEAT);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageMatching("이름의 길이는 1자 이상, 5자 이하만 가능합니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,honux:pobi", "a,b,c:c"}, delimiter = ':')
    void 여러명_입력시_split_검증(String value, String expected) {
        Input input = new Input(value, TEST_REPEAT);
        input.splitInputByComma().contains(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honuxs", "a,b,ccccccc", "a,,b", ""})
    void 여러명_입력시_이름길이_검증(String value) {
        Assertions.assertThatThrownBy(() -> {
            Input input = new Input(value, TEST_REPEAT);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageMatching("이름의 길이는 1자 이상, 5자 이하만 가능합니다.");
    }


    @ParameterizedTest
    @ValueSource(strings = {"ABC", "2147483649"})
    void 횟수_입력시_타입_검증(String value) {
        Assertions.assertThatThrownBy(() -> {
            Input input = new Input(TEST_NAMES, value);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageMatching("횟수는 정수만 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-100", "0"})
    void 횟수_음수_입력시_예외검증(String value) {
        Assertions.assertThatThrownBy(() -> {
            Input input = new Input(TEST_NAMES, value);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageMatching("횟수는 1이상의 정수만 가능합니다.");
    }
}