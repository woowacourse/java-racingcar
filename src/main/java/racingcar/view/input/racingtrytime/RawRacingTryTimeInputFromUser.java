package racingcar.view.input.racingtrytime;

import java.util.Scanner;
import racingcar.view.input.racingtrytime.printer.RacingTryTimeInputFromUserPrinter;

public class RawRacingTryTimeInputFromUser {
    public static String getRacingTryTimeInput(Scanner scanner) {
        RacingTryTimeInputFromUserPrinter.printRacingTryTimeInputMessage();
        return scanner.nextLine();
    }
}
