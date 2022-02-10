package racingcar;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RacingCarController {

    private final Scanner scanner;

    public RacingCarController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        try {
            int tryCount = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new NumberFormatException("시도횟수는 숫자이어야 합니다.");
        }
    }
}
