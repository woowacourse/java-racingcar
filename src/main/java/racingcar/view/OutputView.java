package racingcar.view;

public class OutputView {
    private static final String CAR_NAME_GUIDE_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    private OutputView() {
    }

    public static void showCarNameGuideMessage() {
        System.out.println(CAR_NAME_GUIDE_MESSAGE);
    }
}
