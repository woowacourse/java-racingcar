package console;

import domain.Cars;
import java.util.Map;

public class OutputView {

    private static final String DELIMITER = ", ";

    public static void requestOfCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void requestOfTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printResultMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printWinners(Cars cars) {
        System.out.print(String.join(DELIMITER, cars.getWinner()));
        System.out.println("가 최종 우승했습니다.");
    }

    public static void printCurrentRacingStatus(Cars cars) {
        final Map<String, Integer> currentRacingStatus = cars.getCurrentStatus();

        StringBuilder currentRacingStatusMessage = new StringBuilder();

        for (final String carName : currentRacingStatus.keySet()) {
            currentRacingStatusMessage.append(carName)
                    .append(" : ")
                    .append("-".repeat(currentRacingStatus.get(carName)))
                    .append("\n");
        }

        System.out.println(currentRacingStatusMessage.toString());
    }
}
