package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Winners;

public class OutputView {

    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String LIST_JOIN_DELIMITER = ", ";
    private static final String WINNER_MESSAGE_SUFFIX = "가 최종 우승 했습니다.";

    public static void printCarNamesMessage() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
    }

    public static void printNumberMessage() {
        System.out.println(INPUT_NUMBER_MESSAGE);
    }

    public static void printResultMessage() {
        System.out.println("\n" + RESULT_MESSAGE);
    }

    public static void printTurnResult(Cars cars) {
        for (Car car : cars.getCars()) {
            printCarStatus(car);
        }
        System.out.println();
    }

    private static void printCarStatus(Car car) {
        StringBuilder stringBuilder = new StringBuilder(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            stringBuilder.append("-");
        }
        System.out.println(stringBuilder.toString());
    }

    public static void printWinners(final Winners winners) {
        String winnerNames = String.join(LIST_JOIN_DELIMITER, winners.getWinners());
        System.out.println(winnerNames + WINNER_MESSAGE_SUFFIX);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
