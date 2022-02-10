package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.exception.round.RoundNotNumericException;
import racingcar.utils.Delimiter;
import racingcar.view.reader.DataReader;

public class InputView {

	private final DataReader dataReader;

	public InputView(DataReader dataReader) {
		this.dataReader = dataReader;
	}

	public List<String> requestCarNames() {
		return parsingNames(dataReader.readLine());
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
		return parsingNumber(dataReader.readLine());
	}

	private int parsingNumber(String inputValue) {
		try {
			return Integer.parseInt(inputValue.trim());
		} catch (NumberFormatException exception) {
			throw new RoundNotNumericException();
		}
	}
}
