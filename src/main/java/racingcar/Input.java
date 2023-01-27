package racingcar;

import java.util.Scanner;

public class Input {

    public int getRacingGameCount() {
        System.out.println("시도할 횟수는 몇회인가요?");

        try {
            return inputGameCountString();
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            return getRacingGameCount();
        }
    }

    private int inputGameCountString() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 다시 입력하세요.");
        }

        return Integer.parseInt(input);
    }
}
