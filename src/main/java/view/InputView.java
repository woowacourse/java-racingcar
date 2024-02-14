package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String CAR_NAME_MSG = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_NUMBER_MSG = "시도할 횟수는 몇회인가요?";

    public List<String> inputCarNames() {
        System.out.println(CAR_NAME_MSG);
        Scanner in = new Scanner(System.in);
        String carNames = in.next();
        return Arrays.asList(carNames.split(","));
    }

    public int inputTryNumber() {
        System.out.println(TRY_NUMBER_MSG);
        Scanner in = new Scanner(System.in);
        String tryNumber = in.next();
        // 숫자가 아닌 경우 및 음수인 경우 예외 처리
        return Integer.parseInt(tryNumber);
    }
}
