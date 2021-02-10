package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String CAR_NAME_GUIDE_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String LAP_GUIDE_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String COLON_BETWEEN_NAME_AND_POSITION = " : ";
    private static final String BAR = "-";

    private OutputView() {
    }

    public static void showCarNameGuideMessage() {
        System.out.println(CAR_NAME_GUIDE_MESSAGE);
    }

    public static void showLapGuideMessage() {
        System.out.println(LAP_GUIDE_MESSAGE);
    }

    public static void showOneLapResult(Map<String, Integer> carStatus) {
        carStatus.forEach((name, position) ->
                System.out.println(name + COLON_BETWEEN_NAME_AND_POSITION + showPositionBar(position))
        );
        System.out.println();
    }

    public static String showPositionBar(int position) {
        StringBuilder positionBar = new StringBuilder();
        for (int i = 0; i < position; i++) {
            positionBar.append(BAR);
        }
        return positionBar.toString();
    }

    public static void showWinners(List<String> winners) {
        String result = String.join(", ", winners);
        System.out.println(result + WINNER_MESSAGE);
    }

    public static void showResultMessage() {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
    }
}
