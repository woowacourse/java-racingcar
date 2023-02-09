package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String CAR_POSITION_SIGN = "-";
    private static final String COLON = " : ";
    private static final String DELIMITER = ", ";
    private static final String RESULT_POSTFIX = "가 최종 우승했습니다.";


    public void printPosition(String name, int position) {
        System.out.println(name + COLON + CAR_POSITION_SIGN.repeat(position));
    }

    public void printWinners(List<String> winners) {
        String winnersToString = String.join(DELIMITER, winners);
        System.out.print(winnersToString);
        System.out.println(RESULT_POSTFIX);
    }
}
