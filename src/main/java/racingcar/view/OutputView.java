package racingcar.view;

import java.util.List;

import racingcar.domain.RacingGame;

public class OutputView {
    private static final String COMMA = ",";

    public static void printRoundResult(RacingGame racingGame) {
        racingGame.getRacingCars().forEach(car -> System.out.println(car));
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println(String.join(COMMA, winners) + "가 최종 우승했습니다.");
    }

}
