package racinggame.util;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)를 기준으로 구분).");
        List<String> carNames = Arrays.asList(scanner.nextLine().split(","));

        Validator.checkDuplicateNames(carNames);
        return carNames;
    }

    public static int getTotalTrial() {
        System.out.println("시도할 횟수는 몇회인가요?");
        int trial = scanner.nextInt();

        Validator.checkPositiveNumber(trial);
        return trial;
    }
}
