package racinggame.util;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static List<String> getCarNames() {
        try{
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)를 기준으로 구분).");
            List<String> carNames = Arrays.stream(scanner.nextLine().split(","))
                    .map(String::trim)
                    .collect(Collectors.toList());
            Validator.checkCarNames(carNames);
            return carNames;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return getCarNames();
        }
    }

    public static int getTrial() {
        System.out.println("시도할 횟수는 몇회인가요?");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            e.printStackTrace();
            return getTrial();
        }
    }
}
