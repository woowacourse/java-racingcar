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
		int count = 0;
		try {
			count = Integer.parseInt(s);
		} catch (NumberFormatException exception) {
			throw new RuntimeException("시도 횟수가 숫자가 아닙니다.");
		}
		if (count <= 0) {
			throw new RuntimeException("시도 횟수가 음수나 0이 될 수 없습니다.");
		}
		return count;
	}
}