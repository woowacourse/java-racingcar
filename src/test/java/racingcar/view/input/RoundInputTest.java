package racingcar.view.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.AppConfig;
import racingcar.exception.WrongArgumentException;
import racingcar.exception.status.round.RoundCountExceptionStatus;
import racingcar.view.input.reader.CustomReader;

class RoundInputTest {

    private static final String PROVIDER_PATH = "racingcar.view.input.provider.RoundInputTestProvider#";
    private static final AppConfig APP_CONFIG = AppConfig.getInstance();

    private final CustomReader customReader = APP_CONFIG.reader;
    private final InputView inputView = APP_CONFIG.inputView;

    @DisplayName("숫자 이외의 값은 입력할 수 없다.")
    @ParameterizedTest
    @MethodSource(PROVIDER_PATH + "provideValuesForNotNumericException")
    void roundNotNumericExceptionTest(final String inputValue) {
        customReader.initText(inputValue);
        assertThatThrownBy(inputView::requestRoundCount)
                .isInstanceOf(WrongArgumentException.class)
                .hasMessageContaining(RoundCountExceptionStatus.ROUND_IS_NOT_NUMERIC.getMessage());
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
