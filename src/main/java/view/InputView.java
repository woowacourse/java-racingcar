package view;

import java.util.Scanner;

public class InputView {
    private static final String requestCarNameMessage = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    private static Scanner scanner;

    public static String requestCarName() {
        System.out.println(requestCarNameMessage);
        return input();
    }

    private static String input() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner.nextLine();
    }
}
