package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Name;
import racingcar.domain.Names;
import racingcar.view.reader.DataReader;

public class InputView {

	private static final String CAR_NAME_DELIMITER = ",";
	private final DataReader dataReader;

	public InputView(DataReader dataReader) {
		this.dataReader = dataReader;
	}

	public Names requestCarNames() {
		List<Name> names = Arrays.stream(splitIncludeBlank())
			.map(Name::new)
			.collect(Collectors.toList());
		return new Names(names);
	}

	public String[] splitIncludeBlank() {
		return dataReader.readLine().split(CAR_NAME_DELIMITER, -1);
	}

	public String requestGameRound() {
		return dataReader.readLine().trim();
	}
}
