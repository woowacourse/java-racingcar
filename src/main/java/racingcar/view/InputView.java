package racingcar.view;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private final static String READ_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    public String readCarName() {
        System.out.println(READ_CAR_NAME_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
