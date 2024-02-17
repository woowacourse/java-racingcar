package racingcar.view;

import java.util.List;
import java.util.Map;
import racingcar.model.CarName;
import racingcar.model.Position;
import racingcar.model.RoundResult;
import racingcar.model.TotalResult;

public class OutputView {

    public void printResult(TotalResult totalResult) {
        System.out.println();
        System.out.println("실행 결과");
        totalResult.getTotalResult()
                .forEach(this::printRoundResult);
    }

    public void printWinnerInfo(List<String> winners) {
        System.out.printf("최종 우승자: %s%n", String.join(", ", winners));
    }

    private void printRoundResult(RoundResult roundResult) {
        Map<CarName, Position> result = roundResult.getResult();
        roundResult.getResult()
                .keySet()
                .forEach(key -> convertResultText(key, result));
        System.out.println();
    }

    private void convertResultText(CarName carName, Map<CarName, Position> result) {
        String name = carName.getName();
        int position = result.get(carName).getPosition();
        System.out.printf("%s : %s%n", name, "-".repeat(position));
    }
}
