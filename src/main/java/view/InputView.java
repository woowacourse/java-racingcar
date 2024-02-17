package view;

import domain.RacingGame;
import domain.Round;
import java.util.Scanner;

public class InputView {

    public static RacingGame readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return new RacingGame(read());
    }

    public static Round readRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        return new Round(read());
    }

    private static String read() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
