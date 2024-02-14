package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String CAR_NAME_MSG = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    public List<String> inputCarNames() {
        System.out.println(CAR_NAME_MSG);
        Scanner in = new Scanner(System.in);
        String carNames = in.next();
        return Arrays.asList(carNames.split(","));
    }
}
