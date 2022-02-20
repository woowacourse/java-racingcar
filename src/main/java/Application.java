import racingcar.domain.vo.Attempt;
import racingcar.domain.fcc.Cars;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        Cars cars = inputView.requestCars().getCars();
        Attempt attempt = inputView.requestAttempt().getAttempt();
        RacingGameService service = new RacingGameService(cars);

        outputView.printRaceResult(service.racing(attempt));
        outputView.printWinners(service.findWinners());
    }
}
