package racingcar.input.racingtrytime;

import java.util.Scanner;
import racingcar.input.racingtrytime.validator.RacingTryTimeValidator;

public class ValidRacingTryTimeFromUserGetter {
    private final RawRacingTryTimeInputFromUser racingTryTimeInputFromUser;
    private final RacingTryTimeValidator racingTryTimeValidator;

    public ValidRacingTryTimeFromUserGetter(Scanner scanner) {
        this.racingTryTimeInputFromUser = new RawRacingTryTimeInputFromUser(scanner);
        this.racingTryTimeValidator = new RacingTryTimeValidator();
    }

    public int getRacingTryTime() {
        String racingTryTimeInput = racingTryTimeInputFromUser.getRacingTryTimeInput();
        racingTryTimeValidator.validate(racingTryTimeInput);
        return Integer.parseInt(racingTryTimeInput);
    }
}
