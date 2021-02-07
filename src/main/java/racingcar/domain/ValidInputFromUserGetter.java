package racingcar.domain;

import java.util.List;
import java.util.Scanner;

public class ValidInputFromUserGetter {
    private final ValidCarNamesInputFromUserGetter validCarNamesInputFromUserGetter;
    private final ValidRacingTryTimeFromUserGetter validRacingTryTimeFromUserGetter;

    public ValidInputFromUserGetter(Scanner scanner) {
        this.validCarNamesInputFromUserGetter = new ValidCarNamesInputFromUserGetter(scanner);
        this.validRacingTryTimeFromUserGetter = new ValidRacingTryTimeFromUserGetter(scanner);
    }

    public List<String> getCarNames() {
        return validCarNamesInputFromUserGetter.getCarNames();
    }

    public int getRacingTryTime() {
        return validRacingTryTimeFromUserGetter.getRacingTryTime();
    }
}
