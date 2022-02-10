package racingcar;

import java.util.Scanner;

public class Input {
    private static final String GET_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    private final Scanner scanner = new Scanner(System.in);

    public String inputCarNames() {
        System.out.println(GET_CAR_NAMES);
        return scanner.nextLine();
    }
}
