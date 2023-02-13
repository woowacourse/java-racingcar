package racingcar.view;

import racingcar.domain.Winner;
import racingcar.domain.Winners;

import static java.util.stream.Collectors.joining;
import static racingcar.view.OutputConstant.RESULT_POSTFIX;

public class OutputView {

    private static final String CAR_POSITION_SIGN = "-";
    private static final String COLON = " : ";
    private static final String DELIMITER = ", ";

    public void printPosition(String name, int position) {
        System.out.println(name + COLON + CAR_POSITION_SIGN.repeat(position));
    }

    public void printWinners(Winners winners) {
        System.out.print(winnersToString(winners));
        System.out.println(RESULT_POSTFIX);
    }

    public String winnersToString(Winners winners) {
        return winners.getWinners().stream()
                .map(Winner::getName)
                .collect(joining(DELIMITER));
    }
}
