package view.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import view.InputView;

class InputViewTest {

    private InputView inputView;

    void initInputView(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        inputView = new InputView(new Scanner(System.in));
    }

    @Test
    void 자동차이름_입력값이_빈문자일_경우_오류를던진다() {
        //given
        final String input = "\n";
        initInputView(input);
        //when then
        assertThatThrownBy(inputView::readCarNames).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] ")
            .hasMessageContaining("입력값이 없습니다.");
    }

    @Test
    void 자동차이름_입력값_앞뒤에_공백이존재하면_무시한다() {
        //given
        initInputView("  one,two,three                  ");
        //when
        List<String> result = inputView.readCarNames();
        //then
        assertThat(result).isEqualTo(List.of("one", "two", "three"));
    }

    @MethodSource("correctCarNames")
    @ParameterizedTest
    void 올바른_자동차_이름_입력값을_받았을_때(List<String> carNames) {
        //given
        final String DELIMITER = ",";
        initInputView(String.join(DELIMITER, carNames));
        //when
        List<String> result = inputView.readCarNames();
        //then
        assertThat(result).isEqualTo(carNames);
    }

    static Stream<Arguments> correctCarNames() {
        return Stream.of(
            Arguments.of(List.of("one")),
            Arguments.of(List.of("a", "b")),
            Arguments.of(List.of("a b", "ab wd")),
            Arguments.of(List.of("가나다라마", "마라다나가", "기니디리미"))
        );
    }

    @Test
    void 시도횟수_입력값이_빈문자일_경우_오류를던진다() {
        //given
        final String input = "\n";
        initInputView(input);
        //when then
        assertThatThrownBy(inputView::readCount).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] ")
            .hasMessageContaining("입력값이 없습니다.");
    }

    @ValueSource(strings = {"1.5", "abc", "1.0", "1L"})
    @ParameterizedTest
    void 시도횟수_입력값이_정수가_아닐경우_오류를던진다(String input) {
        //given
        initInputView(input);
        //when then
        assertThatThrownBy(inputView::readCount).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] ")
            .hasMessageContaining("시도횟수는 양의 정수여야합니다.");
    }
}
