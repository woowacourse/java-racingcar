package racingcar;

import java.util.Arrays;
import java.util.List;

public class InputManager {
	public List<String> splitAndSaveCarNames(String carNames) {
		if (carNames.equals("")) {
			throw new RuntimeException("빈 문자열을 자동차 이름으로 입력할 수 없습니다.");
		}
		return Arrays.asList(carNames.split(","));
	}

	public int getTrial(String s) {
		return Integer.parseInt(s);
	}
}