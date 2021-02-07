package racingcar.view;

import racingcar.domain.Names;
import racingcar.domain.Trial;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static Names getNames() {
        OutputView.getCarNames();
        String names = scanner.nextLine();
        return new Names(names);
    }

    public static Trial getTrial() {
        OutputView.getTrials();
        String trial = scanner.nextLine();
        return new Trial(trial);
    }
}
