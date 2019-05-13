package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static util.StringUtils.isNumberString;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요 (이름은 쉼표를(,)를 기준으로 구분).");
        String input = scanner.nextLine();
        return Arrays.asList(input.split(","));
    }

    public static int inputTryNum() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = scanner.nextLine();

        if (!isNumberString(input)) {
            System.out.println("숫자로 입력해주세요.");
            return inputTryNum();
        }
        return Integer.parseInt(input);
    }
}
