package racingcar.view;

import racingcar.domain.CarNames;
import racingcar.domain.TryCount;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static CarNames InputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)를 기준으로 구분).");
        try {
            CarNames carNames = new CarNames(scanner.nextLine());
            return carNames;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return InputCarNames();
        }
    }

    public static TryCount InputRacingTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            String tryCount = scanner.nextLine();
            return new TryCount(tryCount);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return InputRacingTryCount();
        }
    }
}
