package racingcar.view;

import racingcar.constant.Messages;

import java.util.Scanner;

public class InputView {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static String inputCarList() {
        System.out.println(Messages.INPUT_CAR_LIST);
        try {
            return SCANNER.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputCarList();
        }
    }

    public static int inputTryCount() {
        System.out.println(Messages.INPUT_TRY_COUNT);
        try {
            return SCANNER.nextInt();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputTryCount();
        }
    }
}