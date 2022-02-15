package racingcar.view.input;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.view.input.reader.CustomReader;

class CarNameInputTest {

    private static final String providerPath = "racingcar.view.input.provider.CarNamesInputTestProvider#";

    private final CustomReader customReader = new CustomReader();
    private final InputView inputView = new InputViewImpl(customReader);

    @DisplayName("자동차 이름 입력 기능 테스트")
    @ParameterizedTest
    @MethodSource(providerPath + "provideValuesForNormalInput")
    void requestCarNamesTest(String inputValue, List<String> expected) {
        customReader.initText(inputValue);
        List<String> carNames = inputView.requestCarNames();
        assertThat(carNames).isEqualTo(expected);
    }

}
