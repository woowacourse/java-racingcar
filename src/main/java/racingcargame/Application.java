package racingcargame;

import racingcargame.controller.TryNumber;
import racingcargame.domain.Cars;
import racingcargame.view.input.InputView;
import racingcargame.view.output.OutputView;

import static racingcargame.stringutil.Parser.*;

public class Application {
    public static void main(String[] args) {
        Cars cars = new Cars(parseStrings(InputView.askCarNames()));
        TryNumber tryNumber = new TryNumber(InputView.askTotalRounds());
        OutputView.printResultTitle();
        for (int i = 0; i < tryNumber.getTryNumber(); i++) {
            cars.moveOneRound();
            OutputView.printRound(cars.getCars());
        }
        OutputView.printWinners(cars.getWinnerNames());
    }
}
