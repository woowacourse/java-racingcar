package racingcar.input.utils.racingtrytime;

import java.util.Scanner;
import racingcar.input.printer.RacingTryTimeInputFromUserPrinter;

public class RacingTryTimeInputFromUser {
    private final RacingTryTimeInputFromUserPrinter racingTryTimeInputFromUserPrinter;
    private final Scanner scanner;

    public RacingTryTimeInputFromUser(Scanner scanner) {
        this.racingTryTimeInputFromUserPrinter = new RacingTryTimeInputFromUserPrinter();
        this.scanner = scanner;
    }

    public String getRacingTryTimeInput() {
        racingTryTimeInputFromUserPrinter.printRacingTryTimeInputMessage();
        return scanner.next();
    }
}
