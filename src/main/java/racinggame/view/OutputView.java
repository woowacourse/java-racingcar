package racinggame.view;

public class OutputView {
    public static final String NAME_FORMAT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";
    public static final String REPEAT_FORMAT = "시도할 회수는 몇회인가요?";
    public static final String RESULT_FORMAT = "\n실행 결과";
    public static final String WINNER_FORMAT = "가 최종 우승했습니다.";

    /* 인스턴스를 사용하지 않으므로 추가 */
    private OutputView() {

    }

    public static void printLog(String log) {
        System.out.println(log);
    }

    public static void printLine() {
        System.out.println();
    }

    public static void printNameFormat() {
        System.out.println(NAME_FORMAT);
    }

    public static void printRepeatFormat() {
        System.out.println(REPEAT_FORMAT);
    }

    public static void printResultFormat() {
        System.out.println(RESULT_FORMAT);
    }

    public static void printWinners(String winnerNames) {
        System.out.println(winnerNames + WINNER_FORMAT);
    }
}
