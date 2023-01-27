package racingcar;

import java.util.Scanner;

public class Input {

    public int getRacingGameCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return inputGameCountString();
    }

    private int inputGameCountString() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수를 입력하세요.");
        }

        return Integer.parseInt(input);
    }
}
