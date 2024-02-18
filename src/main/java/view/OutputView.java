package view;

import static view.ViewMessages.*;

import domain.Car;
import domain.Cars;
import dto.Winners;

public class OutputView {
    public static void printError(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printResult(Cars cars) {
        for (Car car : cars.getCars()) {
            String.format(
                    RESULT_FORMAT,
                    car.getName(),
                    POSITION_SYMBOL.repeat(car.getPosition())
            );
        }
        printNewLine();
    }

    public static void printWinners(Winners winners) {
        System.out.println(String.join(WINNER_SEPARATOR, winners.winners()) + WINNER_MESSAGE);
    }
}
