package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {

    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";

    private static final String NAME_POSITION_DELIMITER = " : ";
    private static final String PROGRESS_BAR = "-";

    private static final String LIST_JOIN_DELIMITER = ", ";
    private static final String WINNER_MESSAGE = "가 최종 우승 했습니다.";

    public static void printCarNamesMessage() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
    }

    public static void printNumberMessage() {
        System.out.println(INPUT_NUMBER_MESSAGE);
    }

    public static void printResultMessage() {
        System.out.println("\n" + RESULT_MESSAGE);
    }

    public static void printCars(Cars cars) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars.getCars()) {
            stringBuilder.append(car.getName())
                    .append(NAME_POSITION_DELIMITER)
                    .append(PROGRESS_BAR.repeat(car.getPosition()))
                    .append("\n");
        }
        System.out.println(stringBuilder);
    }

    public static void printWinners(Cars cars) {
        System.out.println(String.join(LIST_JOIN_DELIMITER, cars.findWinners()) + WINNER_MESSAGE);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
