package racingcar.view;

import racingcar.domain.RaceResult;

import java.util.List;

public class OutputView {
    public static void outputAllTryCarPosition(List<RaceResult> eachTryCars) {
        System.out.println("\n실행 결과");
        for (RaceResult cars : eachTryCars) {
            System.out.println(cars.carsPositionConsoleView());
        }
    }

    public static void outputWinners(RaceResult raceResult) {
        System.out.println(raceResult.winnersConsoleView());
    }
}
