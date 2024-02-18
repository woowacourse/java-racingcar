package racinggame.view;

import java.util.Scanner;

public class InputView {

    public String readCars() {
        return readLine("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public String readRound() {
        return readLine("시도할 회수는 몇회인가요?");
    }

    private String readLine(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);

        return scanner.nextLine().trim();
    }
}
