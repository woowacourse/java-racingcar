package racingcar.view;

public class OutputCommand {
    private OutputCommand() {
    }

    public static final String ASK_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String ASK_TRY_COUNT = "시도할 회수는 몇회인가요?";
    public static final String INPUT_ERROR_MESSAGE = "입력 중 오류가 발생했습니다.";
    public static final String RESULT_TITLE = "실행 결과";
    public static final String WINNERS_PRINT_FORMAT = "%s가 최종 우승했습니다." + System.lineSeparator();
    public static final String WINNERS_DELIMITER = ", ";
    public static final String HYPHEN = "-";
    public static final String COMMA = ",";
    public static final String CAR_RESULT_FORMAT = "%s : %s" + System.lineSeparator();
    public static final String ERROR_PREFIX = "[ERROR] ";
}
