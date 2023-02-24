package racingcar.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public String readCarNames() {
        return scanner.nextLine();
    }

    public int readTryCount() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] 숫자 형태로 입력해주세요.");
        }
    }
}
