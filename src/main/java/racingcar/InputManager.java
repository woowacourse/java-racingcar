package racingcar;

import java.util.Arrays;
import java.util.List;

public class InputManager {
	public List<String> splitAndSaveCarNames(String carNames) {
		return Arrays.asList(carNames.split(","));
	}
}