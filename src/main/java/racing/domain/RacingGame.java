package racing.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import racing.dto.RacingResult;
import racing.dto.RacingResults;

public class RacingGame {

  private final List<String> carNames;
  private final int maxTurn;

  public RacingGame(List<String> carNames, int maxTurn) {
    this.carNames = carNames;
    this.maxTurn = maxTurn;
  }

  public RacingResults run(NumberGenerator numberGenerator) {
    Cars cars = makeCars();
    Racing racing = new Racing(maxTurn, cars);
    return runningRace(racing, numberGenerator);
  }

  private Cars makeCars() {
    List<Car> cars = carNames.stream()
        .map(name -> new Car(0, name))
        .toList();
    return new Cars(cars);
  }

  private RacingResults runningRace(Racing racing, NumberGenerator numberGenerator) {
    List<RacingResult> racingResults = IntStream.range(0, maxTurn).mapToObj(value -> {
      List<Integer> racingConditions = numberGenerator.generate(carNames.size());
      racing.nextTurn(racingConditions);
      Map<String, Integer> carsStatus = racing.getCarsStatus();
      return new RacingResult(carsStatus);
    }).toList();
    return new RacingResults(racingResults);
  }
}
