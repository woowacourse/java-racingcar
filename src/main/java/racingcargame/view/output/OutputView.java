package racingcargame.view.output;

import racingcargame.domain.CarRaceResult;
import racingcargame.domain.RoundResult;

import java.util.List;

public class OutputView {

    public static void printWinners(List<String> winners) {
        String names = String.join(",", winners);
        System.out.println(names + "가 우승하셨습니다.");
    }

    public static void printEachTime(CarRaceResult carRaceResult) {
        List<RoundResult> roundResultList = carRaceResult.getRoundResultList();
        for (RoundResult roundResult : roundResultList) {
            System.out.println(roundResult);
        }
    }
}
