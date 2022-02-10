package racingcar.view.inputview;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.view.CustomReader;
import racingcar.view.InputView;

public class RoundInputTest {

	private final CustomReader customReader = new CustomReader();
	private final InputView inputView = new InputView(customReader);

	@ParameterizedTest
	@MethodSource("provideValuesForNormalInput")
	void 정상작동테스트(String inputValue, int expected) {
		customReader.setText(inputValue);
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
		customReader.setText(inputValue);
		assertThrows(IllegalArgumentException.class, inputView::requestRoundNumber);
	}

	public static Stream<Arguments> provideValuesForNotNumericException() {
		return Stream.of(
				Arguments.of("1a"),
				Arguments.of(""),
				Arguments.of(" b")
		);
	}

}
