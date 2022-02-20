package racingcar.view.input;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.AppConfig;
import racingcar.view.input.reader.CustomReader;

class CarNameInputTest {

    private static final String PROVIDER_PATH = "racingcar.view.input.provider.CarNamesInputTestProvider#";
    private static final AppConfig APP_CONFIG = AppConfig.getInstance();

    private final CustomReader customReader = APP_CONFIG.reader;
    private final InputView inputView = APP_CONFIG.inputView;

    @DisplayName("자동차 이름 입력 기능 테스트")
    @ParameterizedTest(name = "[{index}] 입력 : \"{0}\", 기대 : {1}")
    @MethodSource(PROVIDER_PATH + "provideValuesForNormalInput")
    void requestCarNamesTest(final String inputValue, final List<String> expected) {
        customReader.initText(inputValue);
        final List<String> carNames = inputView.requestCarNames();
        assertThat(carNames).isEqualTo(expected);
    }

}
