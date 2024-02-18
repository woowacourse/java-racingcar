package racinggame.view;

import java.util.List;
import racinggame.domain.RoundResult;

public class OutputView {

    public void printResult(List<RoundResult> results) {
        results.forEach(this::printEachResult);
    }

    private void printEachResult(RoundResult result) {
        result.carInfos().forEach(carInfo ->
            System.out.format("%s : %s%n", carInfo.name(), "-".repeat(carInfo.position())));
        System.out.println();
    }

    public void printWinner(List<String> results) {
        System.out.format("%s가 최종 우승했습니다.", String.join(", ", results));
    }
}
