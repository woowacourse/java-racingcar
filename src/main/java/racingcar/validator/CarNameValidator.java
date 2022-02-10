package racingcar.validator;

public class CarNameValidator {

	public static void validate(String name) {
		if (name.isBlank()) {
			throw new IllegalArgumentException("유효하지 않은 이름입니다.");
		}
		if (isIllegalLength(name)) {
			throw new IllegalArgumentException("이름을 5글자 이하로 입력해주세요.");
		}
	}

	private static boolean isIllegalLength(String name) {
		return name.length() > 5;
	}
}
