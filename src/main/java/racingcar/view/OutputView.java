package racingcar.view;

import java.util.List;
import java.util.Map;
import racingcar.model.Car;
import racingcar.model.RaceResult;

public class OutputView {

    public void printRaceResult(List<RaceResult> raceResults) {
        System.out.println();
        System.out.println("실행 결과");
        for (RaceResult raceResult : raceResults) {
            printResult(raceResult);
            System.out.println();
        }
    }

    public void printWinnerInfo(List<Car> winners) {
        List<String> winnerNames = winners.stream()
                        .map(Car::getName)
                                .toList();

        System.out.printf("최종 우승자: %s%n", String.join(", ", winnerNames));
    }

    private void printResult(RaceResult raceResult) {
        Map<String, Integer> result = raceResult.getResult();
        for (String carName : result.keySet()) {
            System.out.printf("%s : %s%n", carName, "-".repeat(result.get(carName)));
        }
    }
}
