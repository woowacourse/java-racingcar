package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.Count;
import racingcar.domain.NumberPicker;
import racingcar.domain.RandomNumberPicker;
import racingcar.util.Repeat;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        Cars cars = Repeat.repeatIfError(() -> new Cars(InputView.inputCarName()), OutputView::printErrorMessage);
        Count count = Repeat.repeatIfError(() -> new Count(InputView.inputTryCount()), OutputView::printErrorMessage);
        race(cars, count);
        OutputView.printWinner(cars.findWinner());
    }


    private static void race(Cars cars, Count tryCount) {
        while (!tryCount.isFinished()) {
            cars.moveCars(numberPicker());
            OutputView.printStatus(cars.toDto());
            tryCount.next();
        }
    }


    private static NumberPicker numberPicker() {
        return new RandomNumberPicker();
    }

}
