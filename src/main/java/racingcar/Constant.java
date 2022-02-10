package racingcar;

public class Constant {

    public static final int RANDOM_RANGE = 10;
    public static final int MINIMUM_MOVE = 4;
    public static final int START_POSITION = 0;
    public static final int MAXIMUM_NAME_LENGTH = 5;
    public static final int MINIMUM_NATURAL_NUMBER = 1;

    public static final String POSITION_FLAG = "-";
    public static final String JOIN_REGEX = ", ";
    public static final String COMMA_REGEX = ",";
    public static final String CAR_NAME_PATTERN_REGEX = "^[a-zA-Z,]*$";
    public static final String COIN_PATTERN_REGEX = "^[0-9]*$";

    public static final String NOT_ALPHA_AND_COMMA_ERROR = "[ERROR]: 잘못된 입력입니다.(입력은 영어와 쉼표로만 이루어져있습니다.)";
    public static final String NOT_ALLOW_LENGTH_ERROR = "[ERROR]: 잘못된 입력입니다.(입력은 5자 이하만 가능합니다.)";
    public static final String DUPLICATE_NAME_ERROR = "[ERROR]: 잘못된 입력입니다.(같은 이름의 자동차는 두번 사용할 수 없습니다.)";
    public static final String NOT_NUMERIC_ERROR = "[ERROR]: 잘못된 입력입니다.(시도 횟수는 숫자만 가능합니다.)";
    public static final String MINIMUM_NATURAL_NUMBER_ERROR = "[ERROR]: 잘못된 입력입니다.(1 이상의 값만 입력이 가능합니다.)";

    public static final String PRINT_INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String PRINT_INPUT_COIN_MESSAGE = "시도할 회수는 몇회인가요?";
    public static final String PRINT_RESULT_MESSAGE = "\n실행 결과";
    public static final String PRINT_WINNER_MESSAGE = "가 최종 우승했습니다.";
}
