package racingcargame;

import racingcargame.controller.CarRace;
import racingcargame.controller.TryNumber;
import racingcargame.domain.Cars;
import racingcargame.domain.Names;
import racingcargame.view.input.InputView;
import racingcargame.view.output.OutputView;

public class Application {
    public static void main(String[] args) {
        Cars cars = new Cars(Names.valueOf(InputView.askCarNames()));
        TryNumber tryNumber = new TryNumber(Integer.parseInt(InputView.askTotalRounds()));
        CarRace race = new CarRace(cars, tryNumber);
        race.start();
        OutputView.printResultTitle();
        OutputView.printWinners(cars.findWinnerNames());
    }
}
