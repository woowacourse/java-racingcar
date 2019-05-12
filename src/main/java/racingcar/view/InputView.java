package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_CAR_LIST = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TRY_COUNT = "시도할 회수는 몇회인가요?";

    public static String inputCarList() {
        System.out.println(INPUT_CAR_LIST);
        try {
            return SCANNER.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputCarList();
        }
    }

    public static int inputTryCount() {
        System.out.println(INPUT_TRY_COUNT);
        try {
            return SCANNER.nextInt();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputTryCount();
        }
    }
}