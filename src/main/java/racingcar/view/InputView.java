package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.view.reader.DataReader;

public class InputView {

	private static final String CAR_NAME_DELIMITER = ",";
	private final DataReader dataReader;

	public InputView(DataReader dataReader) {
		this.dataReader = dataReader;
	}

	public List<String> requestCarNames() {
		return Arrays.stream(dataReader.readLine().split(CAR_NAME_DELIMITER, -1))
			.map(String::trim)
			.collect(Collectors.toList());
	}

	public String requestGameRound() {
		return dataReader.readLine().trim();
	}
}
