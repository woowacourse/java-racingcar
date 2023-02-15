package racingcar.view;

public class InputView {
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 횟수는 몇회인가요?";
    private static final String INPUT_TRY_COUNT_ERROR_MESSAGE = "[ERROR] 시도 횟수는 자연수를 입력해주세요.";

    public static void printInputTryCountGuide() {
        System.out.println(INPUT_TRY_COUNT_MESSAGE);
    }

    public static void printInputCarNameGuide() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
    }

    public static String printInputTryCountError() {
        return INPUT_TRY_COUNT_ERROR_MESSAGE;
    }

}
