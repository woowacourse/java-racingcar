package racingcar;

import java.util.Scanner;
import racingcar.vo.Attempt;
import racingcar.vo.Car;
import racingcar.vo.CarName;
import racingcar.vo.Cars;

public class RacingCar {

  private Scanner scanner;

  public RacingCar(Scanner scanner) {
    this.scanner = scanner;
  }

  public void run() {
    String carNamesInput = readNextLine();
    Cars cars = createCars(splitCarNames(carNamesInput));
    String attemptInput = readNextLine();
    Attempt attempt = new Attempt(attemptInput);
  }

  public String readNextLine() {
    return this.scanner.nextLine();
  }

  public String[] splitCarNames(String carNames) {
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
