package racingcar.utils;

public class RacingGameMessage {

	public static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	public static final String INPUT_REPEATS = "시도할 회수는 몇회인가요?";

	public static final String NAME_LENGTH_ERROR = "이름은 5자리 이하만 가능합니다.";
	public static final String REPEATS_ERROR = "반복횟수는 정수만 입력 가능합니다.";

	public static final String TURN_RESULT = "\n실행결과";
	public static final String WINNER = "가 최종 우승했습니다.";
	public static final String CAR_POSITION = "-";
	public static final String NAME_POSITION_SPLITTER = " : ";

	public static final String CAR_NAME_DISTRIBUTOR = ",";

	private RacingGameMessage() {}
}
