package racingcargame.view.output;

import racingcargame.domain.result.CarRaceResult;
import racingcargame.domain.result.RoundResult;

import java.util.List;

public class OutputView {

    private static final String WINNER_FORMATTED_STRING = "%s가 우승하셨습니다.";
    private static final String ROUND_FORMATTED_STRING = "%d 회차";
    public static final int ROUND_INDEX_DIFFERENCE = 1;

    public static void printWinners(CarRaceResult carRaceResult) {
        List<String> winners = carRaceResult.getWinners();
        String names = String.join(",", winners);
        System.out.println(String.format(WINNER_FORMATTED_STRING, names));
    }

    public static void printAllRoundResults(CarRaceResult carRaceResult) {
        List<RoundResult> roundResults = carRaceResult.getRoundResultList();

        System.out.println();
        for (int i = 0; i < roundResults.size(); i++) {
            printRound(roundResults.get(i), i);
        }
    }

    private static void printRound(RoundResult roundResult, int index) {
        System.out.println(String.format(ROUND_FORMATTED_STRING, index + ROUND_INDEX_DIFFERENCE));
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
