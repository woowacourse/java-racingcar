package racingCar.utlis;

public class Constants {

	public static final int GO_RANDOM_INTEGER = 4;
	public static final int RANDOM_MAX_BOUND_INTEGER = 9;

	public static final String REQUEST_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	public static final String REQUEST_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

	public static final String ERROR_MESSAGE = "[ERROR]";
	public static final String EXCEPTION_NULL_MESSAGE = "1자 이상 입력해주세요.";
	public static final String EXCEPTION_NOT_NUMBER_MESSAGE = "숫자를 입력해주세요.";
	public static final String EXCEPTION_ZERO_MESSAGE = "0회 이상 입력해주세요.";
	public static final String EXCEPTION_SPACE_MESSAGE = "이름이 space 로 이뤄져 있습니다";
	public static final String EXCEPTION_NAME_RANGE = "이름은 5자 이하만 가능합니다.";
	public static final String EXCEPTION_SPACIAL_MESSAGE = "이름에는 특수문자가 입력될 수 없습니다.";
	public static final String EXCEPTION_ONE_NAME_MESSAGE = "이름을 2개 이상 입력해주세요.";
	public static final String EXCEPTION_DUPLICATED_NAME_MESSAGE = "중복된 이름이 입력되었습니다.";

	public static final String NAME_REGEX = ",";
	public static final String NOT_SPECIAL_REGEX = "[가-힣\\w_]*";

	public static final String RESULT_FRONT_MESSAGE = "\n실행 결과";
	public static final String ROUND_REGEX = " : ";
	public static final String POSITION_SIGNATURE = "-";

	public static final String WINNER_REGEX = ", ";
	public static final String WINNER_RESULT_LAST_MESSAGE = "가 최종 우승했습니다.";
}
