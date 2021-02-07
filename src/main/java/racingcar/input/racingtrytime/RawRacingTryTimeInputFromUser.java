package racingcar.input.racingtrytime;

import java.util.Scanner;
import racingcar.input.racingtrytime.printer.RacingTryTimeInputFromUserPrinter;

public class RawRacingTryTimeInputFromUser {
    private final RacingTryTimeInputFromUserPrinter racingTryTimeInputFromUserPrinter;
    private final Scanner scanner;

    public RawRacingTryTimeInputFromUser(Scanner scanner) {
        this.racingTryTimeInputFromUserPrinter = new RacingTryTimeInputFromUserPrinter();
        this.scanner = scanner;
    }

    public String getRacingTryTimeInput() {
        racingTryTimeInputFromUserPrinter.printRacingTryTimeInputMessage();
        return scanner.nextLine();
    }
}
