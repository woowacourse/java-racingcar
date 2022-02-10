package racingcar.view;

import java.util.Scanner;

public class Staff {

    private static final String INPUT_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    private static final Scanner scanner = new Scanner(System.in);

    public String getCarNames() {
        System.out.println(INPUT_NAME_MESSAGE);
        return scanner.nextLine();
    }
}
