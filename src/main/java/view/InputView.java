package view;

import domain.Names;
import exception.CommaNotFoundException;
import exception.NameIsOutOfBoundException;

import java.util.Scanner;

public class InputView {

    private static final String COMMA = ",";
    private static final String requestCarNameMessage = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String requestTryCountMessage = "시도할 회수는 몇회인가요?";

    private static Scanner scanner;

    public static Names requestCarName() {
        System.out.println(requestCarNameMessage);

        try {
            return new Names(input());
        } catch (CommaNotFoundException | NameIsOutOfBoundException e) {
            System.out.println(e.getMessage());
            return requestCarName();
        }
    }

    public static String requestTryCount() {
        System.out.println(requestTryCountMessage);
        return input();
    }

    private static String input() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner.nextLine();
    }
}
