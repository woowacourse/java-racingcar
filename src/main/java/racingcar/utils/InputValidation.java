package racingcar.utils;

public class InputValidation {
	private final static String CAR_NAME_DISTRIBUTOR = ",";
	private final static int MAX_NAME_LENGTH = 5;
	private final static String NAME_LENGTH_ERROR = "이름은 5자리 이하만 가능합니다.";

	public void validateName(String names) {
		String[] carNames = names.split(CAR_NAME_DISTRIBUTOR);
		for (String carName : carNames) {
			checkNameLength(carName);
		}
	}

	private void checkNameLength(String carName) {
		if (carName.length() > MAX_NAME_LENGTH) {
			throw new RuntimeException(NAME_LENGTH_ERROR);
		}
	}
}
