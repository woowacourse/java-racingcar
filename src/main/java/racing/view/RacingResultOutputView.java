package racing.view;

import java.util.List;
import java.util.Map;
import racing.dto.RacingResult;
import racing.dto.RacingResults;

public class RacingResultOutputView {

  public static void printResult(RacingResults racingResults) {
    System.out.println("실행 결과");
    racingResults.stream().forEach(RacingResultOutputView::printEachResult);
    printWinner(racingResults);
  }

  private static void printEachResult(RacingResult racingResult) {
    Map<String, Integer> carsStatus = racingResult.getCarsStatus();
    carsStatus.keySet().forEach(carName -> System.out.printf("%s : %s\n", carName,
        "-".repeat(carsStatus.get(carName))));
  }

  private static void printWinner(RacingResults racingResults) {
    List<String> winnerNames = racingResults.getWinnerNames();
    String collectedWinnerName = String.join(", ", winnerNames);
    System.out.printf("%s가 최종 우승했습니다.", collectedWinnerName);
  }
}
