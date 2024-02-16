package racing.domain;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import racing.dto.RacingResult;
import racing.input.CarNameInputManager;
import racing.input.RacingMaxTurnInputManager;
import racing.output.InputGuideOutputManager;
import racing.output.RacingResultOutputManager;
import util.RandomGenerator;
import util.RetryHelper;

public class RacingManager {

  public static void raceStart() {
    Scanner scanner = new Scanner(System.in);
    List<String> carNames = getCarNames(scanner);
    int maxTurn = getMaxTurn(scanner);

    Cars cars = makeCars(carNames);
    Racing racing = new Racing(maxTurn, cars);
    List<RacingResult> racingResults = runningRace(carNames, maxTurn, racing);

    RacingResultOutputManager.printResult(racingResults);
    List<String> winnerNames = racing.getWinnerNames();
    RacingResultOutputManager.printWinner(winnerNames);
  }

  private static List<RacingResult> runningRace(List<String> carNames, int maxTurn,
      Racing racing) {
    return IntStream.range(0, maxTurn).mapToObj(value -> {
      List<Integer> racingConditions = RandomGenerator.generate(carNames.size());
      racing.nextTurn(racingConditions);
      return RacingDTOMapper.from(racing);
    }).toList();
  }

  private static List<String> getCarNames(Scanner scanner) {
    RetryHelper carNameInputManager = new RetryHelper(5);
    return carNameInputManager.retry(
        () -> {
          InputGuideOutputManager.printInputCarNames();
          return CarNameInputManager.getNameFromConsole(scanner);
        });
  }

  private static int getMaxTurn(Scanner scanner) {
    RetryHelper maxTurnInputManager = new RetryHelper(5);
    return maxTurnInputManager.retry(
        () -> {
          InputGuideOutputManager.printInputMaxRacingTurn();
          return RacingMaxTurnInputManager.getMaxTurnFromConsole(scanner);
        });
  }

  private static Cars makeCars(List<String> carNames) {
    List<Car> cars = carNames.stream()
        .map(name -> new Car(0, name))
        .toList();
    return new Cars(cars);
  }
}
