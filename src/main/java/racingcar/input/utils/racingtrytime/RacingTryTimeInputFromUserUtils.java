package racingcar.input.utils.racingtrytime;

import java.util.Scanner;
import racingcar.input.printer.InputPrinter;
import racingcar.input.utils.racingtrytime.validators.RacingTryTimeValidatorUtils;

public class RacingTryTimeInputFromUserUtils {

    private RacingTryTimeInputFromUserUtils() {
    }

    public static int getRacingTryTime(Scanner scanner) {
        InputPrinter.printRacingTryTimeInputMessage();
        String racingTryTimeInput = scanner.next();
        RacingTryTimeValidatorUtils.validateNaturalNumberRacingTime(racingTryTimeInput);
        return Integer.parseInt(racingTryTimeInput);
    }
}
