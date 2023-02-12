package racingcar.ui;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.TextSplit;

public class OutputView {

    private static final String CAR_BASE_STATUS = "-";
    private static final String CAR_TEXT_DELIMITER = ",";

    public static void startRacing() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void tryCount() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }

    public static void error(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void playRound() {
        System.out.println("\n실행 결과");
    }

    public static void result(List<String> carTexts) {
        for (String carText : carTexts) {
            List<String> splitCarText = TextSplit.split(carText, CAR_TEXT_DELIMITER);

            String carName = splitCarText.get(0);
            int position = Integer.parseInt(splitCarText.get(1));

            System.out.println(carName + " : " + CAR_BASE_STATUS.repeat(position));
        }
        System.out.println();
    }

    public static void winner(List<String> winners) {
        String winnerNames = winners.stream()
                .map(carText -> TextSplit.split(carText, CAR_TEXT_DELIMITER))
                .map(carText -> carText.get(0))
                .collect(Collectors.joining(", "));

        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
