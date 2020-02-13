package racingcargame;

import racingcargame.domain.Cars;
import racingcargame.view.input.InputView;
import racingcargame.view.output.OutputView;

import static racingcargame.stringutil.Parser.parseCars;

public class Application {
    public static void main(String[] args) {
        Cars cars = new Cars(parseCars(InputView.askCarNames()));
        cars.moveFoward(Integer.parseInt(InputView.askRound()));
        OutputView.printWinners(cars.getCarNamesInMaxPosition());
    }
}
