package racingcar;

import java.util.Scanner;
import racingcar.vo.Attempt;

public class RacingCar {
  private Scanner scanner;

  public RacingCar(Scanner scanner) {
    this.scanner =  scanner;
  }

  public void run() {
    String carNames = readNextLine();
    String[] names = splitCarNames(carNames);
    Attempt attempt = new Attempt(readNextLine());
  }

  public String readNextLine() {
    return this.scanner.nextLine();
  }

  public String[] splitCarNames(String carNames) {
    return carNames.split(",");
  }
}
