package racing.output;

import java.util.List;
import racing.dto.RacingResult;

public class RacingResultOutputManager {
    public static void printResult(List<RacingResult> racingResults) {
        System.out.println("실행 결과");
        for (RacingResult racingResult : racingResults) {
            printEachResult(racingResult);
        }
    }

    private static void printEachResult(RacingResult racingResult) {
        List<String> names = racingResult.getNames();
        List<String> distances = racingResult.getDistances();
        for (int index = 0; index < names.size(); index++) {
            System.out.printf("%s : %s\n", names.get(index), distances.get(index));
        }
    }

    public static void printWinner(List<String> winnerNames) {
        String collectedWinnerName = String.join(", ", winnerNames);
        System.out.printf("%s가 최종 우승했습니다.", collectedWinnerName);
    }
}
