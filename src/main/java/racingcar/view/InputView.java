package racingcar.view;

import racingcar.domain.Racers;
import racingcar.domain.Trial;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static Racers getRacerNames() {
        String names = scanner.nextLine();
        return new Racers(names);
    }

    public static Trial getTrial() {
        String trial = scanner.nextLine();
        return new Trial(trial);
    }
}
