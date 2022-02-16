import racingcar.domain.dto.ResponseRoundResultDto;
import racingcar.domain.dto.ResponseWinnersDto;
import racingcar.domain.vo.Attempt;
import racingcar.domain.vo.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        Cars cars = inputView.requestCars().getCars();
        Attempt attempt = inputView.requestAttempt().getAttempt();
        outputView.printRaceResult(new ResponseRoundResultDto(cars.repeatRaceBy(attempt)));
        outputView.printWinners(new ResponseWinnersDto(cars.findWinners()));
    }
}
