package racingcar.view;


import static racingcar.view.OutputCommand.CAR_RESULT_FORMAT;
import static racingcar.view.OutputCommand.ERROR_PREFIX;
import static racingcar.view.OutputCommand.HYPHEN;
import static racingcar.view.OutputCommand.RESULT_TITLE;
import static racingcar.view.OutputCommand.WINNERS_DELIMITER;
import static racingcar.view.OutputCommand.WINNERS_PRINT_FORMAT;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Winners;

public class OutputView {
    public static void printInputErrorMessage() {
        System.out.println(ERROR_PREFIX + OutputCommand.INPUT_ERROR_MESSAGE);
    }

    public static void printCars(final Cars cars) {
        cars.getCars().forEach(OutputView::printCarResult);
        printNewLine();
    }

    public static void printCarResult(final Car car) {
        System.out.printf(CAR_RESULT_FORMAT, car.getName(), getRepeatedHyphen(car.getDistance()));
    }

    private static String getRepeatedHyphen(final int distance) {
        return HYPHEN.repeat(distance);
    }

    public static void printResultTitle() {
        printNewLine();
        System.out.println(RESULT_TITLE);
    }

    private static void printNewLine() {
        System.out.print(System.lineSeparator());
    }

    public static void printWinners(final Winners winners) {
        System.out.printf(WINNERS_PRINT_FORMAT, String.join(WINNERS_DELIMITER, winners.getWinners()));
    }
}
