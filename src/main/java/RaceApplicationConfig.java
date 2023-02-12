import controller.NumberRaceController;
import controller.RaceController;
import controller.RaceControllerHandler;
import java.lang.reflect.Proxy;
import java.util.Scanner;
import service.RaceService;
import utils.RacingRandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class RaceApplicationConfig {

    public RaceController raceController() {
        InputView inputView = new InputView(new Scanner(System.in));
        OutputView outputView = new OutputView();
        RaceService raceService = new RaceService();
        RacingRandomNumberGenerator generator = new RacingRandomNumberGenerator();
        RaceController raceController = new NumberRaceController(inputView, outputView, raceService, generator);

        return (RaceController) Proxy.newProxyInstance(RaceController.class.getClassLoader(),
                new Class[]{RaceController.class},
                new RaceControllerHandler(raceController, outputView));
    }
}
