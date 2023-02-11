package console;

import domain.Cars;
import java.util.Map;

public class OutputView {

    private static final String SEPARATOR = " : ";
    private static final String DELIMITER = ", ";
    private static final String MOVE_DISTANCE_COUNT = "-";
    private static final String NEW_LINE = System.lineSeparator();

    public static void requestOfCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void requestOfTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printResultMessage() {
        System.out.println(NEW_LINE + "실행 결과");
    }

    public static void printWinners(Cars cars) {
        System.out.print(String.join(DELIMITER, cars.getWinnerNames()));
        System.out.println("가 최종 우승했습니다.");
    }

    public static void printCurrentRacingStatus(Cars cars) {
        final Map<String, Integer> currentRacingStatus = cars.getCurrentRacingStatus();
        StringBuilder currentRacingStatusMessage = new StringBuilder();

        for (final String carName : currentRacingStatus.keySet()) {
            int countOfMovingDistance = currentRacingStatus.get(carName);
            currentRacingStatusMessage
                    .append(carName)
                    .append(SEPARATOR)
                    .append(MOVE_DISTANCE_COUNT.repeat(countOfMovingDistance))
                    .append(NEW_LINE);
        }

        System.out.println(currentRacingStatusMessage);
    }
}
