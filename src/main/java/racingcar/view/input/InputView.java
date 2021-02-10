package racingcar.view.input;

import java.util.List;
import java.util.Scanner;
import racingcar.view.input.carname.ValidCarNamesInputFromUserGetter;
import racingcar.view.input.racingtrytime.ValidRacingTryTimeFromUserGetter;

public class InputView {
    private final ValidCarNamesInputFromUserGetter validCarNamesInputFromUserGetter;
    private final ValidRacingTryTimeFromUserGetter validRacingTryTimeFromUserGetter;

    public InputView() {
        Scanner scanner = new Scanner(System.in);
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
