package racingcar.view;

import racingcar.domain.RoundResult;
import racingcar.utils.StringUtils;

import java.util.List;

public class OutputView {
    public static void printRaceResult(List<RoundResult> racingResult) {
        System.out.println("\n실행 결과");
        for (RoundResult roundResult : racingResult) {
            System.out.println(roundResult.getFormattedRoundResult());
        }
    }

    public static void printWinners(List<String> winners) {
        if (winners.size() == 0) {
            System.out.println("레이스에 실패하였습니다.");
            return;
        }
        String winnersName = winners.toString();
        System.out.println(
                winnersName.substring(1, winnersName.length() - 1)
                        + StringUtils.differentiateIGa(winnersName.charAt(winnersName.length() - 2))
                        + " 최종 우승했습니다."
        );
    }
}