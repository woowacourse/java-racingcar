package view;

import domain.RacingGame;
import domain.Round;
import java.util.Scanner;

public class InputView {

    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_ROUND = "시도할 회수는 몇회인가요?";

    public static RacingGame readCarNames() {
        System.out.println(INPUT_CAR_NAMES);
        return new RacingGame(read());
    }

    public static Round readRound() {
        System.out.println(INPUT_ROUND);
        return new Round(read());
    }

    private static String read() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
