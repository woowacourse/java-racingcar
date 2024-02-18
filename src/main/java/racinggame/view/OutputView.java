package racinggame.view;

import java.util.List;
import racinggame.domain.RoundResult;

public class OutputView {

    private static final String PROGRESS_SYMBOL = "-";
    private static final String DELIMITER = ", ";

    private OutputView() {
    }

    public static void printResult(List<RoundResult> results) {
        System.out.println();
        System.out.println("실행 결과");
        results.forEach(OutputView::printEachResult);
    }

    private static void printEachResult(RoundResult result) {
        result.carInfos().forEach(carInfo ->
                System.out.format("%s : %s%n", carInfo.name(), PROGRESS_SYMBOL.repeat(carInfo.position())));
        System.out.println();
    }

    public static void printWinner(List<String> results) {
        System.out.format("%s가 최종 우승했습니다.", String.join(DELIMITER, results));
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }
}
