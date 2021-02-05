package racingcar.view;

import java.util.Scanner;

public class InputView {
    public static String inputCarName(Scanner scanner) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        return scanner.next();
    }

    public static String inputRaceTime(Scanner scanner) {
        System.out.println("시도할 회수는 몇회인가요?");

        return scanner.next();
    }
}
