package racing.view;

import racing.domain.Car;
import racing.domain.RacingGame;

public class OutputView {

    public static void printRacing(RacingGame racingGame) {
        for (Car car : racingGame.getResult()) {
            System.out.println(car);
        }
        System.out.println();
    }

    public static void printWinners(RacingGame racingGame) {
        String winners = String.join(", ", racingGame.getWinners());
        System.out.printf("%s가 최종 우승했습니다.\n", winners);
    }
}
