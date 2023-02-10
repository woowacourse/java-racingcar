package racingcar.view;

import racingcar.Winners;

import java.util.List;

import static racingcar.view.OutputConstant.RESULT_POSTFIX;

public class OutputView {

    private static final String CAR_POSITION_SIGN = "-";
    private static final String COLON = " : ";
    private static final String DELIMITER = ", ";

    public void printPosition(String name, int position) {
        System.out.println(name + COLON + CAR_POSITION_SIGN.repeat(position));
    }

    public void printWinners(List<String> winners) {
        String winnersToString = String.join(DELIMITER, winners);
        System.out.print(winnersToString);
        System.out.println(RESULT_POSTFIX);
    }
}
