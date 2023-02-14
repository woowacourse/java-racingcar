import controller.RaceController;
import java.util.Scanner;
import utils.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RaceController raceController = new RaceController(
            new InputView(scanner),
            new OutputView(),
            new RandomNumberGenerator()
        );
        raceController.play();
        scanner.close();
    }
}
