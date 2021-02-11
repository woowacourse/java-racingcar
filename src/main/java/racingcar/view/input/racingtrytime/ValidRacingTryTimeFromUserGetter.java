package racingcar.view.input.racingtrytime;

import java.util.Scanner;
import racingcar.view.input.racingtrytime.validator.RacingTryTimeValidator;

public class ValidRacingTryTimeFromUserGetter {
    public static int getRacingTryTime(Scanner scanner) {
        String racingTryTimeInput
            = RawRacingTryTimeInputFromUser.getRacingTryTimeInput(scanner);
        RacingTryTimeValidator.validate(racingTryTimeInput);
        return Integer.parseInt(racingTryTimeInput);
    }
}
