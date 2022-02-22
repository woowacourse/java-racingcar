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

		String[] carNames = inputView.requestCarNames();

		assertThat(carNames.length).isEqualTo(expected.size());

		int index = 0;
		for (String name : carNames) {
			assertThat(name).isEqualTo(expected.get(index++));
		}
	}

	@Test
	void 자동차이름_콤마로_끝날때_공백_포함해서_split_한다() {
		customReader.setText("pobi,if  ,  hanul,");
		List<String> expected = Arrays.asList(
			"pobi",
			"if",
			"hanul"
		);

		String[] carNames = inputView.requestCarNames();

		assertThat(carNames.length).isEqualTo(expected.size() + 1);
	}
}
