package racingcar.view;

import java.util.Scanner;

public class Input {
    public static String inputCarNames() {
        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String inputName = sc.next();
        return inputName;
    }

    public static String inputTry() {
        Scanner sc = new Scanner(System.in);
        System.out.println("시도할 회수는 몇회인가요?");
        String inputTry = sc.next();
        return inputTry;
    }
}
