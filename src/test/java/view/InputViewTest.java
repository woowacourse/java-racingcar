package view;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    InputView inputView = new InputView();

    @DisplayName("숫자가 아닌 값이 시도 횟수로 들어오면 에러를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", " "})
    void validateTryTimesTypeTest(String tryTimes) {
        Assertions.assertThatThrownBy(
            () -> inputView.validateTryTimes(tryTimes)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 횟수로 1보다 작은 수가 들어오면 에러를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0"})
    void validateTryTimesRangeTest(String tryTimes) {
        Assertions.assertThatThrownBy(
            () -> inputView.validateTryTimes(tryTimes)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}