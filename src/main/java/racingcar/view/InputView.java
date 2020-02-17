package racingcar.view;

import racingcar.domain.Names;
import racingcar.domain.Trial;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static Names getNames() {
        try {
            OutputView.askCarNames();
            String carNames = scanner.nextLine();
            return new Names(carNames);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getNames();
        }
    }

    public static Trial getTrial() {
        try {
            OutputView.askTrial();
            String trial= scanner.nextLine();
            return new Trial(trial);
        } catch (Exception e) {
            OutputView.printErrorMessage(e.getMessage());
            return getTrial();
        }
    }
}
