package racingCar.view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputValue() {
        return scanner.nextLine();
    }

    public String[] inputCarNames() {
        String cars = scanner.nextLine();
        return cars.split(",");
    }

}
