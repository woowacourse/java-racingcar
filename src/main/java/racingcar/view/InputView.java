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

    public List<String> readCarNames() {
        outputView.printNames();

        String line = scanner.nextLine();
        validateCarNames(line);

        return Arrays.asList(line.split(","));
    }

    public int readGameRound() {
        outputView.printGameRoundGuide();

        String line = scanner.nextLine();

        return Integer.parseInt(line);
    }

    private void validateCarNames(String line) {
        if (line.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 공백은 입력할 수 없습니다.");
        }
    }
}
