package racingcar.view.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.exception.WrongArgumentException;
import racingcar.view.input.reader.CustomReader;
import racingcar.view.output.OutputView;

class RoundInputTest {

    private static final String PROVIDER_PATH = "racingcar.view.input.provider.RoundInputTestProvider#";

    private final CustomReader customReader = new CustomReader();
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView(customReader, outputView);

    @DisplayName("숫자 이외의 값은 입력할 수 없다.")
    @ParameterizedTest
    @MethodSource(PROVIDER_PATH + "provideValuesForNotNumericException")
    void roundNotNumericExceptionTest(final String inputValue) {
        customReader.initText(inputValue);
        assertThrows(WrongArgumentException.class, inputView::requestRoundCount);
    }

    @DisplayName("실행횟수 입력 기능 테스트")
    @ParameterizedTest
    @MethodSource(PROVIDER_PATH + "provideValuesForNormalInput")
    void requestRoundNumberTest(final String inputValue, final int expected) {
        customReader.initText(inputValue);
        final int number = inputView.requestRoundCount();
        assertThat(number).isEqualTo(expected);
    }

}
