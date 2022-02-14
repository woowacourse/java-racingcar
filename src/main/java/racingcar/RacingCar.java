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

  private static final String CAR_NAME_DELIMITER = ",";

  public RacingCar() {
  }

  public void play() {
    Cars cars = createCars(splitCarNames(requestCarName()));
    Attempt attempt = new Attempt(requestAttempt());
    printRaceResult(cars.repeatRaceBy(attempt));
    printWinners(cars.judgeWinners());
  }

  private String[] splitCarNames(String carNames) {
    return carNames.split(CAR_NAME_DELIMITER);
  }

  // FIXME Cars를 생성하는 책임을 Cars에게 줄 수 있다면?
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
