package racingcar.view.input;

import java.util.List;
import java.util.Scanner;
import racingcar.view.input.carname.ValidCarNamesInputFromUserGetter;
import racingcar.view.input.racingtrytime.ValidRacingTryTimeFromUserGetter;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> getCarNames() {
        return ValidCarNamesInputFromUserGetter.getCarNames(scanner);
    }

    public static int getRacingTryTime() {
        return ValidRacingTryTimeFromUserGetter.getRacingTryTime(scanner);
    }
}
