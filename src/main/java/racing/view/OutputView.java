package racing.view;

import racing.model.Position;

public class OutputView {

    private static final String COLON = " : ";
    private static final String DASH = "-";
    public static final String INPUT_CARNAMES_GUIDE_MESSAGE = "경주할 자동차 이름을 입력하세(이름은 쉼표(,)를 기준으로 구분";
    public static final String INPUT_TRIAL_TIME_GUIDE_MESSAGE = "시도할 횟수는 몇회인가요?";
    public static final String RESULT_HEADING = "실행 결과";

    public static void printInputCarNamesMessage() {
        System.out.println(INPUT_CARNAMES_GUIDE_MESSAGE);
    }

    public static void printInputTrialTimeMessage() {
        System.out.println(INPUT_TRIAL_TIME_GUIDE_MESSAGE);
    }

    public static void printExceptionMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printResultMessage() {
        System.out.println(RESULT_HEADING);
    }

    public static void printCurrentDashResult(String name, Position position) {
        StringBuilder result = new StringBuilder();
        result.append(name);
        result.append(COLON);
        for (int index = 0; index < position.getPosition(); index++){
            result.append(DASH);
        }
        System.out.println(result);
    }

    public static void printWinners(String winners) {
        System.out.println(winners);
    }
}
