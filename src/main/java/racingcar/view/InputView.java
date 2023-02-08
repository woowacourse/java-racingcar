package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner;
    private final OutputView outputView;

    public InputView(Scanner scanner, OutputView outputView) {
        this.scanner = scanner;
        this.outputView = outputView;
    }

    public List<String> readCars() {
        OutputView.printNames();
        String line = scanner.nextLine();
        String[] splitLine = line.split(",");
        return Arrays.asList(splitLine);
    }

    public int readGameRound() {
        outputView.printGameRoundGuide();
        String line = scanner.nextLine();
        return Integer.parseInt(line);
    }

}
