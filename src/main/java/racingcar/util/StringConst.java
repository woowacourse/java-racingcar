package racingcar.util;

public enum StringConst {
	INPUT_CAR_NAME_MESSAGE("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
	DELIMITER(","),
	INPUT_TURN_MESSAGE("시도할 회수는 몇회인가요?"),
	OUTPUT_DELIMITER(" : "),
	POSITION_DELEIMIER("-"),
	WINNER_DELIMITER(", "),
	WINNER_MESSAGE("가 최종 우승했습니다."),
	RESULT_MESSAGE("실행 결과"),
	REGEX_PATTERN("^[0-9|a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힣]+$"),
    NUMBER_REGEX_PATTERN("^[0-9]+$");

	private final String value;

	StringConst(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
