package racingcar;

import java.util.List;

public class InputValidator {
	public void checkCarNameLength(List<String> carNames) {
		for (String carName : carNames) {
			if (carName.length() > 5) {
				throw new RuntimeException("자동차 이름은 5자 이하여야 합니다.");
			}
		}
	}

	public void validateIsSpace(List<String> carNames) {
		for (String carName : carNames) {
			if (carName.equals("")) {
				throw new RuntimeException("모든 자동차 이름은 반드시 존재해야 합니다.");
			}
			if (carName.trim().equals("")) {
				throw new RuntimeException("자동차 이름은 공백으로 설정할 수 없습니다.");
			}
		}
	}
}
