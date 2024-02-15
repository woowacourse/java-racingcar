package racingcar.view;

import java.util.LinkedHashMap;
import java.util.List;
import racingcar.model.RoundResult;
import racingcar.model.TotalResult;

public class OutputView {

    public void printResult(TotalResult totalResult) {
        System.out.println();
        System.out.println("실행 결과");
        for (RoundResult roundResult : totalResult.getTotalResult()) {
            LinkedHashMap<String, Integer> result = roundResult.getResult();
            for (String s : result.keySet()) {
                System.out.println(s + " : " + "-".repeat(result.get(s)));
            }
            System.out.println();
        }
    }

    public void printWinnerInfo(List<String> winners) {
        System.out.printf("최종 우승자: %s%n", String.join(", ", winners));
    }
}
