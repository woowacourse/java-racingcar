package racingcar.view.inputview;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.exception.round.RoundNotNumericException;
import racingcar.view.input.InputView;
import racingcar.view.inputview.reader.CustomReader;
import racingcar.view.input.InputViewImpl;

@SuppressWarnings("NonAsciiCharacters")
public class RoundInputTest {

    private final CustomReader customReader = new CustomReader();
    private final InputView inputView = new InputViewImpl(customReader);

    @ParameterizedTest
    @MethodSource("provideValuesForNormalInput")
    void 정상작동테스트(String inputValue, int expected) {
        customReader.initText(inputValue);
        int number = inputView.requestRoundNumber();
        assertThat(number).isEqualTo(expected);
    }

    public static Stream<Arguments> provideValuesForNormalInput() {
        return Stream.of(
                Arguments.of("1", 1),
                Arguments.of("22", 22),
                Arguments.of(" 2", 2),
                Arguments.of("-3", -3)
        );
    }

    @ParameterizedTest
    @MethodSource("provideValuesForNotNumericException")
    void 숫자이외의값입력_예외테스트(String inputValue) {
        customReader.initText(inputValue);
        assertThrows(RoundNotNumericException.class, inputView::requestRoundNumber);
    }

    public static Stream<Arguments> provideValuesForNotNumericException() {
        return Stream.of(
                Arguments.of("1a"),
                Arguments.of(""),
                Arguments.of(" b")
        );
    }

}
