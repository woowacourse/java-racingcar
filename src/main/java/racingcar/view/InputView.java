package racingcar.view;

import static racingcar.constant.ViewMessage.*;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	private static final String SPLIT_DELIMITER = ",";

	public List<String> readCarNames() {
		System.out.println(INPUT_CAR_NAMES.getMessage());
		return Arrays.stream(Console.readLine().strip().split(SPLIT_DELIMITER))
				.map(String::strip)
				.toList();
	}

	public String readTryCount() {
		System.out.println(INPUT_TRY_COUNT.getMessage());
		return Console.readLine().strip();
	}
}
