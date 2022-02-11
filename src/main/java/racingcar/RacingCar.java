package racingcar;

import static racingcar.view.InputView.requestCarName;
import static racingcar.view.InputView.requestAttempt;
import static racingcar.view.OutputView.printRaceResult;
import static racingcar.view.OutputView.printWinners;

import racingcar.vo.Attempt;
import racingcar.vo.Car;
import racingcar.vo.CarName;
import racingcar.vo.Cars;

public class RacingCar {

  public RacingCar() {
  }

  public void run() {
    Cars cars = createCars(splitCarNames(requestCarName()));
    Attempt attempt = new Attempt(requestAttempt());
    printRaceResult(cars.repeatRace(attempt));
    printWinners(cars.getWinners());
  }

  private String[] splitCarNames(String carNames) {
    return carNames.split(",");
  }

  private Cars createCars(String[] names) {
    Cars cars = new Cars();
    for (String name : names) {
      cars.add(createCar(name));
    }
    return cars;
  }

  private Car createCar(String name) {
    return new Car(new CarName(name));
  }
}
