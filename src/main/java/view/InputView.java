package view;

public class InputView {

    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    public void printInputCarNameGuide() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
    }

    public void printInputTryCountGuide() {
        System.out.println(INPUT_TRY_COUNT_MESSAGE);
    }
}
