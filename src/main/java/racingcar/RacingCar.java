package racingcar;

import racingcar.domain.dto.ResponseRoundResultDto;
import racingcar.domain.dto.ResponseWinnersDto;
import racingcar.view.InputView;
import racingcar.domain.vo.Attempt;
import racingcar.domain.vo.Cars;
import racingcar.view.OutputView;

public class RacingCar {

    public RacingCar() {
    }

    public void play() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        Cars cars = inputView.requestCars().getCars();
        Attempt attempt = inputView.requestAttempt().getAttempt();
        outputView.printRaceResult(new ResponseRoundResultDto(cars.repeatRaceBy(attempt)));
        outputView.printWinners(new ResponseWinnersDto(cars.findWinners()));
    }
}
