import controller.RacingGameController;
import domain.GameProcess;
import utils.DefaultMovingStrategy;
import view.IOViewResolver;
import view.InputView;
import view.OutputView;

public class Manager {
    private static final GameProcess INITIAL_STATUS = GameProcess.READ_CAR_NAMES;

    private Manager() {
        throw new AssertionError();
    }

    public static void run() {
        IOViewResolver ioViewResolver = new IOViewResolver(InputView.getInstance(), OutputView.getInstance());
        RacingGameController controller = new RacingGameController(ioViewResolver, new DefaultMovingStrategy());

        GameProcess process = INITIAL_STATUS;
        while (process != GameProcess.EXIT) {
            process = controller.run(process);
        }
    }
}
