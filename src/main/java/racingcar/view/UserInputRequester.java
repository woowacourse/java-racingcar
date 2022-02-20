package racingcar.view;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class UserInputRequester {

    private final Scanner scanner;

    public UserInputRequester() {
        this.scanner = new Scanner(System.in);
    }

    public String getCarName() {
        InputView.requestCarName();
        return readNextLine();
    }

    public String getAttempt() {
        InputView.requestAttempt();
        return readNextLine();
    }

    private String readNextLine() {
        try {
            return scanner.nextLine();
        } catch (NoSuchElementException exception) {
            throw new RuntimeException(ErrorMessage.INPUT_EMPTY.getMessage());
        }
    }
}
