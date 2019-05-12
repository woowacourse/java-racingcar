package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.RoundResult;
import racingcar.utils.StringUtils;

import java.util.List;

public class OutputView {
    public static void printRound(RoundResult roundResult) {
        roundResult.getFormattedRoundResult().forEach(x -> System.out.println(x));
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        String winnersName = winners.toString();
        System.out.println(
                winnersName.substring(1, winnersName.length() - 1)
                        + StringUtils.differentiateIGa(winnersName.charAt(winnersName.length() - 2))
                        + " 최종 우승했습니다."
        );
    }
}