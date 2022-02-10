package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputManager {

	public static List<String> splitAndSaveCarNames(String carNamesLine) {
		if (carNamesLine.equals("")) {
			throw new RuntimeException("빈 문자열을 자동차 이름으로 입력할 수 없습니다.");
		}
		List<String> carNames = Arrays.asList(carNamesLine.split(","));
		InputValidator.checkCarNameLength(carNames);
		InputValidator.validateIsSpace(carNames);
		InputValidator.validateDuplication(carNames);
		return carNames;
	}

	public static int getTrial(String s) {
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