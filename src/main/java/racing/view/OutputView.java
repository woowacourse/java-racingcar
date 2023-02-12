package racing.view;

import racing.domain.Car;
import racing.domain.RacingGame;

public class OutputView {

    public static void printBeforeRacing() {
        System.out.println("실행 결과");
    }

    public static void printRacing(final RacingGame racingGame) {
        for (Car car : racingGame.decideResult()) {
            System.out.println(car);
        }
        System.out.println();
    }

    public static void printWinners(final RacingGame racingGame) {
        String winners = String.join(", ", racingGame.decideWinners());
        System.out.printf("%s가 최종 우승했습니다.\n", winners);
    }
}
