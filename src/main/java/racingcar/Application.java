package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.domain.DefaultRandomNumberGenerator;
import racingcar.repository.CarRepository;
import racingcar.service.RacingGameService;
import racingcar.view.View;

public class Application {

    private CarRepository carRepository;
    private RacingGameService racingGameService;
    private RacingGameController racingGameController;
    private View view;
    private RetryableTemplate retryableTemplate;

    public void init() {
        carRepository = new CarRepository();
        racingGameService = new RacingGameService(carRepository,
            new DefaultRandomNumberGenerator());
        racingGameController = new RacingGameController(carRepository,
            racingGameService);
        view = new View();
        retryableTemplate = new RetryableTemplate();
    }

    public void run() {
        retryableTemplate.execute(this::inputCarNames, this::handleException);
        retryableTemplate.execute(this::inputTryCount, this::handleException);

        view.printResultViewTitle();
        while (!racingGameController.isFinished()) {
            racingGameController.proceedTurn();
            view.printMidtermResult(racingGameController.getMidtermResult());
        }
        view.printWinnerResult(racingGameController.getWinnerResult());
    }

    public void inputCarNames() {
        racingGameController.inputCarNames(view.inputCarNames());
    }

    public void inputTryCount() {
        racingGameController.inputTryCount(view.inputTryCount());
    }

    private void handleException(Exception e) {
        view.printErrorMessage(e.getMessage());
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.init();
        application.run();
    }
}
