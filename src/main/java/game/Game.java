package game;

import java.util.Scanner;

public class Game {



    String inputCarNames() {
        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분");
        return sc.nextLine();
    }

    String removeBlank(String carNames) {
        return carNames.replace(" ", "");
    }

    String[] splitWithComma(String carNames) {
        return carNames.split(",");
    }

    boolean checkCarNameLength(String carNames) {
        return carNames.length() <= 5;
    }
}
