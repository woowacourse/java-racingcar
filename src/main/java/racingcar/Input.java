package racingcar;

import java.util.Scanner;

public class Input {

    private final Scanner scanner = new Scanner(System.in);

    public int getRacingGameCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return inputGameCountString();
    }

    private int inputGameCountString() {
        return scanner.nextInt();
    }
}
