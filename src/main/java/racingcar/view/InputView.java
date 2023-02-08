package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> readCars() {
        OutputView outputView = new OutputView();
        outputView.printNames();
        String line = scanner.nextLine();
        String[] splitLine = line.split(",");
        return Arrays.asList(splitLine);
    }


}
