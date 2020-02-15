package racingcargame;

import racingcargame.controller.TryNumber;
import racingcargame.domain.Cars;
import racingcargame.view.input.InputView;
import racingcargame.view.output.OutputView;

import static racingcargame.stringutil.Parser.parseCars;
import static racingcargame.stringutil.Parser.parseRound;

public class Application {
    public static void main(String[] args) {
        Cars cars = new Cars(parseCars(InputView.askCarNames()));
        TryNumber tryNumber = new TryNumber(InputView.askTotalRounds());
        OutputView.printResultTitle();
        for (int i = 0; i < tryNumber.getTryNumber(); i++) {
            cars.moveOneRound();
            OutputView.printRound(cars.getCars());
        }
//        OutputView.printWinners(cars.getWinners());
    }
}
