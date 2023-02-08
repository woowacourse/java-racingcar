package racingcar.view;

import java.util.List;

public class OutputView {
    public void printRoundResult(List<String> roundResult) {
        for (String eachCarResult : roundResult) {
            System.out.println(eachCarResult);
        }
    }
}
