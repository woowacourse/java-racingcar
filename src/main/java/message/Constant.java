package message;

public class Constant {

    public static final String RESULT = "실행 결과";
    public static final String WIN_MENTION = "%s가 최종 우승했습니다.%n";
    public static final String SEPARATOR = ",";
    public static final String WINNER_CONNECTOR = ", ";
    public static final String STICK = "-";
    public static final String CAR_NAMES_MENTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String NUMBER_OF_TIME_MENTION = "시도할 횟수는 몇회인가요?";

    public static final int RANDOM_UPPER_BOUND = 10;
    public static final int START_DISTANCE = 0;
    public static final int LENGTH_LOWER_BOUND = 1;
    public static final int LENGTH_UPPER_BOUND = 5; // 이거는 Length Exception 에서 사용하는 이름임
    public static final int MOVE_BOUNDARY = 4;
    public static final int NUMBER_OF_TIME_LOWER_BOUND = 0;
    public static final int NUMBER_OF_TIME_UPPER_BOUND = 101;
}
