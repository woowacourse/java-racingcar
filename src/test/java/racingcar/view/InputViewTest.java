package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.NotANumberException;
import racingcar.exception.TryNumberOutOfRangeException;
import racingcar.view.reader.ConsoleReader;

class InputViewTest {

    InputView setupInputStream(String inputString) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(byteArrayInputStream);
        return new InputView(new ConsoleReader(System.in));
    }

    @Test
    @DisplayName("이름을 입력받고, 쉼표를 기준으로 올바르게 나눈다.")
    void nameSplitTest() {
        // given
        InputView view = setupInputStream("aru,polla,hogi");
        // when
        List<String> names = view.getNames();
        // then
        assertThat(names).containsExactly("aru", "polla", "hogi");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "101", "1000"})
    @DisplayName("시도한 횟수가 범위를 벗어나면, 예외를 발생한다")
    void tryCountOutOfRangeTest(String input) {
        // given
        InputView view = setupInputStream(input);
        // when, then
        assertThatThrownBy(view::getTryNumber)
                .isInstanceOf(TryNumberOutOfRangeException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "100"})
    @DisplayName("시도한 범위가 올바른 범위라면, 양의 정수로 변환한다")
    void tryCountConvertTest(String input) {
        // given
        InputView view = setupInputStream(input);
        // when
        int actual = view.getTryNumber();
        int expected = Integer.parseInt(input);
        // then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "", "\n", "1v", " "})
    @DisplayName("횟수로 숫자가 아닌 문자열이 입력되면 예외를 발생한다.")
    void invalidTryCountTest(String input) {
        // given
        InputView view = setupInputStream(input);
        // when, then
        assertThatThrownBy(view::getTryNumber)
                .isInstanceOf(NotANumberException.class);
    }
}
