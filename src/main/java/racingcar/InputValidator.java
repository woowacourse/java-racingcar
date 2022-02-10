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
}
