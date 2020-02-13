package racingcar.view;

import racingcar.domain.Names;
import racingcar.domain.Trial;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static void getNames() {
        try {
            OutputView.askCarNames();
            String carNames = scanner.nextLine();
            new Names(carNames);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            getNames();
        }
    }

    public static void getTrial() {
        try {
            OutputView.askTrial();
            String trial = scanner.nextLine();
            new Trial(trial);
        } catch (Exception e) {
            OutputView.printErrorMessage(e.getMessage());
            getTrial();
        }
    }
}
