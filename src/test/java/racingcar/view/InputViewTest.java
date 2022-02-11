package racingcar.view;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class InputViewTest {

	private final CustomReader customReader;
	private final InputView inputView;

	public InputViewTest() {
		customReader = new CustomReader();
		inputView = new InputView(customReader);
	}

	@Test
	void 자동차이름_입력_정상_테스트() {
		customReader.setText("pobi,if,hanul");
		List<String> expected = Arrays.asList(
			"pobi",
			"if",
			"hanul"
		);
		List<String> carNames = inputView.requestCarNames();

		assertThat(carNames.size()).isEqualTo(expected.size());

		for (int i = 0; i < carNames.size(); i++) {
			assertThat(carNames.get(i)).isEqualTo(expected.get(i));
		}
	}

	@Test
	void 자동차이름_공백_제거() {
		customReader.setText("pobi,if  ,  hanul");
		List<String> expected = Arrays.asList(
			"pobi",
			"if",
			"hanul"
		);
		List<String> carNames = inputView.requestCarNames();

		assertThat(carNames.size()).isEqualTo(expected.size());

		for (int i = 0; i < carNames.size(); i++) {
			assertThat(carNames.get(i)).isEqualTo(expected.get(i));
		}
	}
}
