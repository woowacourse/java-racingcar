package racingcar.view;

public class OutputView {

    public static void printInputCarNamesMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void printInputAttemptNumberMessage() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }

    public static void printExecutionResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printWinnerCarNamesMessage(String carNames) {
        System.out.println(String.format("%s가 최종우승 했습니다.", carNames));
    }

    public static void printCarStateMessage(String carName, String carPosition) {
        System.out.println(String.format("%s : %s", carName, carPosition));
    }

    public static void printNextLine() {
        System.out.println();
    }
}