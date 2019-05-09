package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> inputCarNames() {
        System.out.println("경주할 자동차를 입력하세요. (이름은 쉼표(,) 기준으로 구분");
        return Arrays.asList(scanner.nextLine().split(","));
    }

    public static int inputNumberOfTimes() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }
}
