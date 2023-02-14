import controller.NumberRaceController;
import controller.RaceController;
import controller.RaceControllerHandler;
import java.lang.reflect.Proxy;
import java.util.Scanner;
import model.RaceGame;
import utils.RacingRandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class RaceApplicationConfig {

    public RaceController raceController() {
        RacingRandomNumberGenerator generator = new RacingRandomNumberGenerator();
        RaceGame raceGame = new RaceGame(generator);
        InputView inputView = new InputView(new Scanner(System.in));
        OutputView outputView = new OutputView();
        RaceController raceController = new NumberRaceController(inputView, outputView, raceGame);

        return (RaceController) Proxy.newProxyInstance(RaceController.class.getClassLoader(),
                new Class[]{RaceController.class},
                new RaceControllerHandler(raceController, outputView));
    }
}
