package racingcar.view.inputview;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.view.inputview.reader.CustomReader;
import racingcar.view.input.InputView;

@SuppressWarnings("NonAsciiCharacters")
public class CarNameInputTest {

	private final CustomReader customReader = new CustomReader();
	private final InputView inputView = new InputView(customReader);

	@ParameterizedTest
	@MethodSource("provideValuesForNormalInput")
	void 정상작동테스트(String inputValue, List<String> expected) {
		customReader.initText(inputValue);
		List<String> carNames = inputView.requestCarNames();
		assertThat(carNames).isEqualTo(expected);
	}

	public static Stream<Arguments> provideValuesForNormalInput() {
		return Stream.of(
				Arguments.of("aaa,bbb,ccc", Arrays.asList("aaa", "bbb", "ccc")),
				Arguments.of(" aaa,bbb,ccc ", Arrays.asList("aaa", "bbb", "ccc")),
				Arguments.of("aaa, bbb ,ccc", Arrays.asList("aaa", "bbb", "ccc")),
				Arguments.of("aaa,b b b,ccc", Arrays.asList("aaa", "b b b", "ccc"))
		);
	}

}
