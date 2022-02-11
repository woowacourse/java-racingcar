package racingcar.view.input;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.exception.round.RoundNotNumericException;
import racingcar.utils.Delimiter;
import racingcar.view.input.reader.Reader;

public class InputView {

	private final Reader reader;

	public InputView(Reader reader) {
		this.reader = reader;
	}

	public List<String> requestCarNames() {
		return parsingNames(reader.readLine());
	}

	private List<String> parsingNames(String inputValue) {
		inputValue = appendSpaceBeforeSplit(inputValue);
		return Arrays.stream(Delimiter.splitWithComma(inputValue))
				.map(String::trim).collect(Collectors.toList());
	}

	private String appendSpaceBeforeSplit(String targetString) {
		return Delimiter.appendSpaceBehind(targetString);
	}

	public int requestRoundNumber() {
		return parsingNumber(reader.readLine());
	}

	private int parsingNumber(String inputValue) {
		try {
			return Integer.parseInt(inputValue.trim());
		} catch (NumberFormatException exception) {
			throw new RoundNotNumericException();
		}
	}

}
