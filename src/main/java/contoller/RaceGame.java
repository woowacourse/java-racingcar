package contoller;

import domain.Car;
import java.util.List;
import java.util.stream.Collectors;
import strategy.NumberGenerator;
import strategy.RandomNumberGenerator;
import view.OutputView;

public class RaceGame {

  private static final NumberGenerator powerSupplier = new RandomNumberGenerator();
  private int roundCount;
  private List<Car> cars;

  public RaceGame(List<String> runnerNames, int roundCount) {
    this.roundCount = roundCount;
    this.cars = makeCars(runnerNames);
  }

  public void race() {
    OutputView.printStart();
    printCarsStatus();
    for (int i = 0; i < roundCount; i++) {
      runRound(cars);
      printCarsStatus();
    }
  }

  private void printCarsStatus() {
    cars.forEach(car -> OutputView.printCarStatus(car.getName(), car.getPosition()));
    System.out.println();
  }

  private List<Car> makeCars(List<String> carNames) {
    return carNames.stream()
        .map(Car::new)
        .collect(Collectors.toList());
  }

  private void runRound(List<Car> cars) {
    for (Car car : cars) {
      car.move(powerSupplier.generate());
    }
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
