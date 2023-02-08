package view;

import static utils.Notice.ENTER_CAR_NAME;
import static utils.Notice.ENTER_TRY_TIMES;
import static utils.Notice.FINAL_WINNER;
import static utils.Notice.RESULT;

import domain.Cars;

public class OutputView {

    public static void printInputCarNamesNotice() {
        System.out.println(ENTER_CAR_NAME.of());
    }

    public static void printInputTryTimesNotice() {
        System.out.println(ENTER_TRY_TIMES.of());
    }

    public static void printCarNameAndPosition(Cars cars) {
        for (String status : cars.getStatuses()) {
            System.out.println(status);
        }
        System.out.println();
    }

    public static void printResultNotice() {
        System.out.println(RESULT.of());
    }

    public static void printWinner(String winnerNames) {
        System.out.println(winnerNames + FINAL_WINNER.of());
    }
}
