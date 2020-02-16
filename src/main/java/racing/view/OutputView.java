package racing.view;

public class OutputView {

    public static void printInputCarNamesMessage() {
        System.out.println("경주할 자동차 이름을 입력하세(이름은 쉼표(,)를 기준으로 구분");
    }

    public static void printInputTrialTimeMessage() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }

    public static void printExceptionMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printCurrentDashResult(String currentResult) {
        System.out.println(currentResult);
    }

    public static void printWinners(String winners) {
        System.out.println(winners);
    }
}
