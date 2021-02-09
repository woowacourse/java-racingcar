package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class OutputView {
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_ATTEMPT_NUMBER_MESSAGE = "시도할 횟수는 몇회인가요?";
    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "%s가 최종우승 했습니다.";
    private static final String CAR_STATE_MESSAGE = "%s : %s";
    private static final String HYPHEN = "-";
    private static final String COMMA_SPACE = ", ";

    private OutputView() {}

    public static void printInputCarNamesMessage() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
    }

    public static void printInputAttemptNumberMessage() {
        System.out.println(INPUT_ATTEMPT_NUMBER_MESSAGE);
    }

    public static void printExecutionResultMessage() {
        System.out.println(EXECUTION_RESULT_MESSAGE);
    }

    public static void printCarStateMessage(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(String.format(CAR_STATE_MESSAGE, car.getName(), positionToHyphen(car)));
        }
        System.out.println();
    }

    public static String positionToHyphen(Car car) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < car.getPosition(); i++) {
            sb.append(HYPHEN);
        }
        return sb.toString();
    }

    public static void printWinnerCarNamesMessage(List<Car> winners) {
        System.out.println(String.format(WINNER_MESSAGE, getWinnerNames(winners)));
    }

    public static String getWinnerNames(List<Car> winners) {
        StringBuilder sb = new StringBuilder();
        sb.append(winners.get(0).getName());
        for (int i = 1; i < winners.size(); i++) {
            sb.append(COMMA_SPACE);
            sb.append(winners.get(i).getName());
        }
        return sb.toString();
    }

    public static void printNextLine() {
        System.out.println();
    }
}