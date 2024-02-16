package racingcar.view;

import java.util.List;
import java.util.Map;
import racingcar.model.RoundResult;
import racingcar.model.TotalResult;

public class OutputView {

    public void printResult(TotalResult totalResult) {
        System.out.println();
        System.out.println("실행 결과");
        for (RoundResult roundResult : totalResult.getTotalResult()) {
            Map<String, Integer> result = roundResult.getResult();
            printRoundResult(result);
            System.out.println();
        }
    }

    public void printWinnerInfo(List<String> winners) {
        System.out.printf("최종 우승자: %s%n", String.join(", ", winners));
    }

    private void printRoundResult(Map<String, Integer> roundResult) {
        for (String carName : roundResult.keySet()) {
            System.out.printf("%s : %s%n", carName, "-".repeat(roundResult.get(carName)));
        }
    }
}
