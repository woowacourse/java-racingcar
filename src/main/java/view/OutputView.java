package view;

import dto.CarState;
import dto.RacingResult;
import dto.RacingStatus;

import java.util.List;

import static view.ViewMessages.*;

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

    public static void printResult(RacingResult racingResult) {
        printResultMessage();
        printRacingStatuses(racingResult);
        printWinners(racingResult.winners());
    }

    private static void printRacingStatuses(RacingResult racingResult) {
        for (RacingStatus racingStatus : racingResult.racingStatuses()) {
            for (CarState carState : racingStatus.carStates()) {
                System.out.println(formatCarState(carState));
            }
            printNewLine();
        }
    }

    private static String formatCarState(CarState carState) {
        return String.format(
                RESULT_FORMAT,
                carState.carName(),
                POSITION_SYMBOL.repeat(carState.position())
        );
    }

    public static void printWinners(List<String> winners) {
        System.out.println(String.join(WINNER_SEPARATOR, winners) + WINNER_MESSAGE);
    }
}
