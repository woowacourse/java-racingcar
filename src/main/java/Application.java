import java.util.Scanner;
import racingcar.RacingCar;

public class Application {

    public static void main(String[] args) {
        RacingCar racingCar = new RacingCar();
        Scanner scanner = new Scanner(System.in);
        racingCar.play(scanner);
    }
}
