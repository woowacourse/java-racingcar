import java.util.Scanner;
import racingcar.RacingCar;

public class Application {

  public static void main() {
    Scanner scanner = new Scanner(System.in);
    RacingCar racingCar = new RacingCar(scanner);
    racingCar.run();
  }
}
