package racingcar.view;

import java.util.List;
import java.util.StringJoiner;
import racingcar.domain.car.Car;

public class OutputView {

    private static final String SEPARATOR = ", ";
    private static final String POSITION_TO_STRING = "-";
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TRY_NUMBER_MESSAGE = "시도할 횟수는 몇회인가요?";
    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_CAR_NAMES_MESSAGE = "%s가 최종우승 했습니다.";
    private static final String CAR_STATE_MESSAGE = "%s : %s";
    private static final int ZERO = 0;
    private static final StringBuilder STRING_BUILDER = new StringBuilder();

    private OutputView() {
    }

    public static void printInputCarNamesMessage() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
    }

    public static void printInputTryNumberMessage() {
        System.out.println(INPUT_TRY_NUMBER_MESSAGE);
    }

    public static void printExecutionResultMessage() {
        System.out.println(EXECUTION_RESULT_MESSAGE);
    }

    public static void printWinnerCarNamesMessage(final List<Car> cars) {
        StringJoiner stringJoiner = new StringJoiner(SEPARATOR);
        for (Car car : cars) {
            stringJoiner.add(car.getName());
        }
        System.out.println(String.format(WINNER_CAR_NAMES_MESSAGE, stringJoiner.toString()));
    }

    public static void printCarStateMessage(final List<Car> cars) {
        for (Car car : cars) {
            System.out.println(String.format(CAR_STATE_MESSAGE, car.getName(), positionToString(car.getPosition())));
        }
        printNextLine();
    }

    public static void printNextLine() {
        System.out.println();
    }

    private static String positionToString(final int value) {
        STRING_BUILDER.setLength(ZERO);
        for (int i = ZERO; i < value; i++) {
            STRING_BUILDER.append(POSITION_TO_STRING);
        }
        return STRING_BUILDER.toString();
    }
}