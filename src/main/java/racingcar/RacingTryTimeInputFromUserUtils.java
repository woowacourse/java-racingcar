package racingcar;

import java.util.Scanner;
import racingcar.input.InputPrinter;
import racingcar.input.utils.racingtrytime.validators.RacingTryTimeValidatorUtils;

public class RacingTryTimeInputFromUserUtils {
    public static int getRacingTryTime(Scanner scanner) {
        InputPrinter.printRacingTryTimeInputMessage();
        String racingTryTimeInput = scanner.next();
        RacingTryTimeValidatorUtils.validateNaturalNumberRacingTime(racingTryTimeInput);
        return Integer.parseInt(racingTryTimeInput);
    }
}
