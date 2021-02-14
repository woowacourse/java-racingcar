package racingcar;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        GameRunner gameRunner = new GameRunner(scanner);
        gameRunner.run();
    }
}
