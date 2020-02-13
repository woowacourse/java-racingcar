package racingcargame;

import racingcargame.domain.Cars;
import racingcargame.view.input.InputView;
import racingcargame.view.output.OutputView;

import static racingcargame.stringutil.Parser.parseCars;
import static racingcargame.stringutil.Parser.parseRound;

public class Application {
    public static void main(String[] args) {
        Cars cars = new Cars(parseCars(InputView.askCarNames()));
        int repeat = parseRound(InputView.askTotalRounds());
        OutputView.printResultTitle();
        for (int i = 0; i < repeat; i++) {
            cars.moveOneRound();
            OutputView.printRound(cars.getCars());
        }
        OutputView.printWinners(cars.getCarNamesInMaxPosition());
    }
}
