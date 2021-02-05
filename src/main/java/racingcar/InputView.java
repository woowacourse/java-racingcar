package racingcar;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String getInputCarsName() {
        OutputView.printAskCarNames();
        return scanner.nextLine().trim();
    }

    public Integer getInputTurns() {
        OutputView.printAskTurns();
        int turns = scanner.nextInt();
        if (turns <= 0) {
            throw new RuntimeException();
        }
        return turns;
    }
}
