package application.racing.view;

import java.util.Scanner;

public class InputViewer {
    private final static String GET_CARS_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private final static String GET_RACING_LAB_MESSAGE = "시도할 회수는 몇회인가요?";

    private static Scanner scanner = new Scanner(System.in);

    public static String getCarsName() {
        System.out.println(GET_CARS_NAME_MESSAGE);
        return scanner.nextLine();
    }

    public static String getRacingLab() {
        System.out.println(GET_RACING_LAB_MESSAGE);
        return scanner.nextLine();
    }
}
