package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final String CAR_NAME_PROMPT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    private final Scanner sc;

    public InputView(Scanner sc) {
        this.sc = sc;
    }


    public String inputCarNames() {
        System.out.println(CAR_NAME_PROMPT);
        return sc.nextLine();
    }
}
