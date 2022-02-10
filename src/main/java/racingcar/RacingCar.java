package racingcar;

import java.util.Scanner;

public class RacingCar {
  private Scanner scanner;

  public RacingCar(Scanner scanner) {
    this.scanner =  scanner;
  }

  public String readCarNames() {
    return this.scanner.nextLine();
  }

  public String[] splitCarNames(String carNames) {
    return carNames.split(",");
  }
}
