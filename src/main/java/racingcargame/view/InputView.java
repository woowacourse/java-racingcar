package racingcargame.view;

import java.util.List;
import java.util.Scanner;

import racingcargame.domain.Repeat;
import racingcargame.domain.car.Name;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static List<Name> inputNames() {
        String userInputName = scanner.nextLine();
        return Name.createNameObjects(userInputName);
    }

    public static Repeat inputRepeats() {
        String userInputRepeat = scanner.nextLine();
        return new Repeat(userInputRepeat);
    }
}
