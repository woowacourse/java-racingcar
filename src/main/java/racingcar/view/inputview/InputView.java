package racingcar.view.inputview;

import java.util.Scanner;

public abstract class InputView {
    private Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    protected String nextLine() {
        return scanner.nextLine();
    }

    public abstract String inputCarNames();

    public abstract String inputTrialTimes();
}
