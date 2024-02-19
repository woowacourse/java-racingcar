package view;

import static view.ViewMessages.*;

import dto.CarStatus;
import dto.CarsStatus;
import dto.RaceResult;
import dto.Winners;

public class OutputView {
    public static void printError(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printRaceResult(RaceResult raceResult) {
        System.out.println(RESULT_MESSAGE);
        for(CarsStatus carsStatus : raceResult.results()) {
            printCarsStatus(carsStatus);
        }
    }

    private static void printCarsStatus(CarsStatus carsStatus) {
        for(CarStatus carStatus : carsStatus.status()) {
            System.out.println(getStatusFormat(carStatus));
        }
        printNewLine();
    }

    private static String getStatusFormat(CarStatus carStatus) {
        return String.format(
                RESULT_FORMAT,
                carStatus.name(),
                POSITION_SYMBOL.repeat(carStatus.position())
        );
    }

    public static void printWinners(Winners winners) {
        System.out.println(String.join(WINNER_SEPARATOR, winners.winners()) + WINNER_MESSAGE);
    }
}
