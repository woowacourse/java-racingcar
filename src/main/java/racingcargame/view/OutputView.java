package racingcargame.view;

public class OutputView {
    private static final String CAR_NAMES_INPUT_GUIDE_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String RACE_COUNT_INPUT_GUIDE_MESSAGE = "시도할 회수는 몇회인가요?";

    private OutputView() {
    }

    public static void showCarNamesInputGuideMessage() {
        print(CAR_NAMES_INPUT_GUIDE_MESSAGE);
    }

    public static void showRaceCountInputGuideMessage() {
        print(RACE_COUNT_INPUT_GUIDE_MESSAGE);
    }

    private static void print(String message) {
        System.out.println(message);
    }
}
