package racingcargame.view.output;

import racingcargame.domain.result.CarRaceResult;
import racingcargame.domain.result.RoundResult;

import java.util.List;

public class OutputView {

    public static void printWinners(List<String> winners) {
        String names = String.join(",", winners);
        System.out.println(names + "가 우승하셨습니다.");
    }

    public static void printAllRounds(CarRaceResult carRaceResult) {
        List<RoundResult> roundResults = carRaceResult.getRoundResultList();

        System.out.println();
        for (int i = 0; i < roundResults.size(); i++) {
            printRound(roundResults.get(i), i);
        }
    }

    private static void printRound(RoundResult roundResult, int index) {
        System.out.println(index + 1 + "회차");
        System.out.println(roundResult.getStatus());
        System.out.println();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void printError(IllegalArgumentException iae) {
        System.out.println(iae.getMessage());
    }
}
