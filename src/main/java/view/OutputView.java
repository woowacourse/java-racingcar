package view;

import model.Cars;
import java.util.List;

public class OutputView {

    private static final String WINNER_NAME_DELIMITER = ", ";

    public void writeResultMessage() {
        System.out.println("\n실행 결과");
    }

    public void writeRoundResult(Cars cars) {
        System.out.println(cars);
    }

    public void writeWinners(List<String> names) {
        String winners = String.join(WINNER_NAME_DELIMITER, names);
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
