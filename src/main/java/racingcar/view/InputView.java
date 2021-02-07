package racingcar.view;

import racingcar.utils.InputValidation;

import java.util.Scanner;

public class InputView {
    private Scanner scanner;
    private InputValidation inputValidation;

    public InputView() {
        this.scanner = new Scanner(System.in);
        inputValidation = new InputValidation();
    }

    public String[] inputCarName() {
        String[] name = scanner.nextLine()
                .replace(" ", "")
                .split(",");
        inputValidation.validateName(name);
        return name;
    }

    public int inputTime() {
        String input = scanner.nextLine();
        inputValidation.validateTime(input);
        return Integer.parseInt(input);
    }
}
