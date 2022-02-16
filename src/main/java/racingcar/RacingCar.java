package racingcar;

import static racingcar.view.InputView.requestAttempt;
import static racingcar.view.OutputView.printRaceResult;
import static racingcar.view.OutputView.printWinners;

import racingcar.dto.ResponseRoundResultDto;
import racingcar.dto.ResponseWinnersDto;
import racingcar.view.InputView;
import racingcar.vo.Attempt;
import racingcar.vo.Car;
import racingcar.vo.CarName;
import racingcar.vo.Cars;

public class RacingCar {

    public RacingCar() {
    }

    public void play() {
        Cars cars = InputView.requestCars().getCars();
        Attempt attempt = requestAttempt().getAttempt();
        printRaceResult(new ResponseRoundResultDto(cars.repeatRaceBy(attempt)));
        printWinners(new ResponseWinnersDto(cars.findWinners()));
    }
}
