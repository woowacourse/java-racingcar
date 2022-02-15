package racingcar.view.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.exception.WrongArgumentException;
import racingcar.view.input.reader.CustomReader;

class RoundInputTest {

    private static final String providerPath = "racingcar.view.input.provider.RoundInputTestProvider#";

    private final CustomReader customReader = new CustomReader();
    private final InputView inputView = new InputView(customReader);

    @DisplayName("숫자 이외의 값은 입력할 수 없다.")
    @ParameterizedTest
    @MethodSource(providerPath + "provideValuesForNotNumericException")
    void roundNotNumericExceptionTest(String inputValue) {
        customReader.initText(inputValue);
        assertThrows(WrongArgumentException.class, inputView::requestRoundNumber);
    }

    @DisplayName("실행횟수 입력 기능 테스트")
    @ParameterizedTest
    @MethodSource(providerPath + "provideValuesForNormalInput")
    void requestRoundNumberTest(String inputValue, int expected) {
        customReader.initText(inputValue);
        int number = inputView.requestRoundNumber();
        assertThat(number).isEqualTo(expected);
    }

}
