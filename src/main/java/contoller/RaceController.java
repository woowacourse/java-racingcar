package contoller;

import domain.Car;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import strategy.NumberGenerator;
import strategy.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class RaceController {

  private static final NumberGenerator powerSupplier = new RandomNumberGenerator();
  private int roundCount;
  private List<Car> cars;

  public void run() {
    this.cars = makeCars(repeat(InputView::readCarNames));
    this.roundCount = repeat(InputView::readTrialNum);
    race();
    OutputView.printWinners(pickWinner());
  }

  private List<Car> makeCars(List<String> carNames) {
    return carNames.stream()
        .map(Car::new)
        .collect(Collectors.toList());
  }

  private <T> T repeat(Supplier<T> inputReader) {
    try {
      return inputReader.get();
    } catch (Exception e) {
      OutputView.printErrorMessage(e);
      return repeat(inputReader);
    }
  }

  private void race() {
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
