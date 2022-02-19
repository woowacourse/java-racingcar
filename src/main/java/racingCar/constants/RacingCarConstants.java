package racingCar.constants;

public class RacingCarConstants {
	public static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	public static final String INPUT_COUNT_MESSAGE = "시도할 횟수는 몇회인가요?";
	public static final String EXECUTION_RESULT_MESSAGE = "실행 결과";
	public static final String FINAL_WINNER_MESSAGE = "가 최종 우승했습니다.";

	public static final String SPLIT_COMMA = ",";
	public static final String CAR_MOVE = "-";
	public static final String CAR_NAME_PATTERN_REGEX = "^[a-zA-Z0-9+,]*$";

	public static final int GO_OR_NOT = 4;
	public static final int CAR_INITIAL_POSITION = 0;

	public static final String CAR_NAME_WRONG_LENGTH_ERROR = "자동차 이름의 길이는 1~5자여야 한다";
	public static final String GAME_COUNT_POSITIVE_INTEGER_ERROR = "시도 횟수는 0이상의 정수여야 한다";
	public static final String CAR_NAME_WRONG_INPUT_ERROR = "자동차 이름의 입력 형식이 잘못되었습니다.";

}
