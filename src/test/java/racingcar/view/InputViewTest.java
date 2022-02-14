package racingcar.view;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import racingcar.domain.Name;
import racingcar.domain.Names;

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

		Names carNames = inputView.requestCarNames();

		assertThat(carNames.getSize()).isEqualTo(expected.size());

		int index = 0;
		for (Name name : carNames.getNames()) {
			assertThat(name.getName()).isEqualTo(expected.get(index++));
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

		String[] carNames = inputView.splitIncludeBlank();

		assertThat(carNames.length).isEqualTo(expected.size() + 1);
	}
}
