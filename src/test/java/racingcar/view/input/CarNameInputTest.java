package racingcar.view.input;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.view.input.reader.CustomReader;
import racingcar.view.output.OutputView;

class CarNameInputTest {

    private static final String PROVIDER_PATH = "racingcar.view.input.provider.CarNamesInputTestProvider#";

    private final CustomReader customReader = new CustomReader();
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView(customReader, outputView);

    @DisplayName("자동차 이름 입력 기능 테스트")
    @ParameterizedTest
    @MethodSource(PROVIDER_PATH + "provideValuesForNormalInput")
    void requestCarNamesTest(final String inputValue, final List<String> expected) {
        customReader.initText(inputValue);
        final List<String> carNames = inputView.requestCarNames();
        assertThat(carNames).isEqualTo(expected);
    }

}
