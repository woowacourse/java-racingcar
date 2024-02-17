package racing.output;

import java.util.List;
import java.util.Map;
import racing.dto.RacingResult;

public class RacingResultOutputManager {
    public static void printResult(List<RacingResult> racingResults) {
        System.out.println();
        System.out.println("실행 결과");
        for (RacingResult racingResult : racingResults) {
            printEachResult(racingResult);
            System.out.println();
        }
    }

    private static void printEachResult(RacingResult racingResult) {
        Map<String, Integer> carsStatus = racingResult.getCarsStatus();
        carsStatus.keySet().forEach(carName -> System.out.printf("%s : %s\n", carName,
                "-".repeat(carsStatus.get(carName))));
    }

    public static void printWinner(List<String> winnerNames) {
        String collectedWinnerName = String.join(", ", winnerNames);
        System.out.printf("%s가 최종 우승했습니다.", collectedWinnerName);
    }
}
