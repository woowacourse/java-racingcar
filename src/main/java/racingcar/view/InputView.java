package racingcar.view;

import racingcar.TryCount;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String InputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public static TryCount InputRacingTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            int num = scanner.nextInt();
            return new TryCount(num);
        } catch (InputMismatchException e) {
            e.printStackTrace();
            scanner.nextLine();
            return InputRacingTryCount();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return InputRacingTryCount();
        }
    }
}
