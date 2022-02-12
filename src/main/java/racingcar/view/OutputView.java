package racingcar.view;

public class OutputView {

    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";

    public static void printCarNamesMessage() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
    }

    public static void printNumberMessage() {
        System.out.println(INPUT_NUMBER_MESSAGE);
    }

    public static void printResultMessage() {
        System.out.println("\n" + RESULT_MESSAGE);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
