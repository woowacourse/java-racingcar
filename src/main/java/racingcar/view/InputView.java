package racingcar.view;

import racingcar.view.reader.DataReader;

public class InputView {

	private static final String CAR_NAME_DELIMITER = ",";
	private static final int INCLUDE_BLANK_OPTION = -1;
	private final DataReader dataReader;

	public InputView(DataReader dataReader) {
		this.dataReader = dataReader;
	}

	public String[] requestCarNames() {
		return consoleReadLine().split(CAR_NAME_DELIMITER, INCLUDE_BLANK_OPTION);
	}

	public String requestGameRound() {
		return consoleReadLine().trim();
	}

	private String consoleReadLine() {
		return dataReader.readLine();
	}
}
