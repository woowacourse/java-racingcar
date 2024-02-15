package view;

public class ViewMessages {
    private ViewMessages() {

    }
    // 자동차 이름 요청
    public static final String CAR_NAMES_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String CAR_NAMES_SPLIT_SYMBOL = ",";

    // 반복 횟수 요청
    public static final String COUNT_REQUEST_MESSAGE = "시도할 회수는 몇회인가요?";

    // 실행 결과 출력
    public static final String RESULT_MESSAGE = "실행 결과";
    public static final String RESULT_FORMAT = "%s : %s";
    public static final String POSITION_SYMBOL = "-";

    // 우승자 출력
    public static final String WINNER_SEPARATOR = ", ";
    public static final String WINNER_MESSAGE = "가 최종 우승했습니다.";
}
