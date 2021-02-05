package racingcar.view;

public class OutputView {
    private static final String ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ENTER_TRIALS = "시도할 횟수는 몇 회인가요?";
    private static final String RESULT_TITLE = "실행 결과";

    private OutputView() {}

    public static void enterCarNames() {
        System.out.println(ENTER_CAR_NAMES);
    }

    public static void printErrorMessage(String e) {
        System.out.println(e);
    }

    public static void enterTrials() {
        System.out.println(ENTER_TRIALS);
    }

    public static void printCurrentResult(String currentPosition) {
        System.out.println(currentPosition);
    }

    public static void printResultTitle() {
        System.out.println(RESULT_TITLE);
    }
}
