package domain;

import java.util.List;
import java.util.stream.Collectors;
import strategy.PowerSupplier;
import strategy.RandomPowerSupplier;
import view.OutputView;

public class RaceGame {

  private final OutputView outputView = new OutputView();
  private final PowerSupplier powerSupplier = new RandomPowerSupplier();

  private List<String> runnerNames;
  private int roundCount;
  private List<Car> cars;

  public RaceGame(List<String> runnerNames, int roundCount) {
    this.runnerNames = runnerNames;
    this.roundCount = roundCount;
    this.cars = makeCars(runnerNames);
  }

  public void race() {
    outputView.printStart(cars);
    for (int i = 0; i < roundCount; i++) {
      runRound(cars);
    }
  }

  private List<Car> makeCars(List<String> carNames) {
    return carNames.stream()
        .map(Car::new)
        .collect(Collectors.toList());
  }

  private void runRound(List<Car> cars) {
    for (Car car : cars) {
      car.move(powerSupplier.supply());
    }
    outputView.printCarsStatus(cars);
  }

  public List<String> pickWinner() {
    int maxPosition = getMaxPosition(cars);

    List<String> winnerNames = cars.stream()
        .filter(c -> c.getPosition() == maxPosition)
        .map(Car::getName)
        .collect(Collectors.toList());
    return winnerNames;
  }

  private int getMaxPosition(List<Car> cars) {
    return cars.stream()
        .max(Car::compareTo)
        .orElseThrow()
        .getPosition();
  }
}
