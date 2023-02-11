package racingcar.view;

import static racingcar.view.OutputConstant.RESULT_POSTFIX;

public class OutputView {

    private static final String CAR_POSITION_SIGN = "-";
    private static final String COLON = " : ";

    public void printPosition(String name, int position) {
        System.out.println(name + COLON + CAR_POSITION_SIGN.repeat(position));
    }

    public void printWinners(String winners) {
        System.out.print(winners);
        System.out.println(RESULT_POSTFIX);
    }
}
