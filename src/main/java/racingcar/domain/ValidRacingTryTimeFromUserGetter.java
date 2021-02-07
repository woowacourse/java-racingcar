package racingcar.domain;

import java.util.Scanner;
import racingcar.input.utils.racingtrytime.RacingTryTimeInputFromUser;

public class ValidRacingTryTimeFromUserGetter {
    private final RacingTryTimeInputFromUser racingTryTimeInputFromUser;
    private final RacingTryTimeValidator racingTryTimeValidator;

    public ValidRacingTryTimeFromUserGetter(Scanner scanner) {
        this.racingTryTimeInputFromUser = new RacingTryTimeInputFromUser(scanner);
        this.racingTryTimeValidator = new RacingTryTimeValidator();
    }

    public int getRacingTryTime() {
        String racingTryTimeInput = racingTryTimeInputFromUser.getRacingTryTimeInput();
        racingTryTimeValidator.validate(racingTryTimeInput);
        return Integer.parseInt(racingTryTimeInput);
    }
}
