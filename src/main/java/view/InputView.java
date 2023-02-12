package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static List<String> receiveCarNamesInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine().replaceAll("\\s", "");
        return Arrays.asList(input.split(","));
    }

    public static String receiveTrialInput() {
        System.out.println("시도할 횟수는 몇회인가요?");
        return scanner.nextLine();
    }
}
