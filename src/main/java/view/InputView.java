package view;

import java.util.Scanner;

import domain.Names;
import domain.RepeatCount;

public class InputView {

    private static final String READ_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String READ_ATTEMPT_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";

    private static final Scanner scanner = new Scanner(System.in);

    public static Names readNames() {
        String line = readLine(READ_CAR_NAME_MESSAGE);

        try {
            return new Names(line);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readNames();
        }
    }

    public static RepeatCount readRepeatCount() {
        String line = readLine(READ_ATTEMPT_NUMBER_MESSAGE);

        try {
            return new RepeatCount(line);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readRepeatCount();
        }
    }

    private static String readLine(String message) {
        System.out.println(message);
        return scanner.next();
    }
}
