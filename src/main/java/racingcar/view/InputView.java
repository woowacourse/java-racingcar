package racingcar.view;

import racingcar.domain.Names;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static Names getNames() {
        String names = scanner.nextLine();
        return new Names(names);
    }
}
