package racingcargame;

import racingcargame.domain.Cars;
import racingcargame.domain.RacingGameResult;
import racingcargame.domain.TryNumber;
import racingcargame.domain.Winners;
import racingcargame.exception.CarNameInputException;
import racingcargame.exception.CarsNameInputException;
import racingcargame.exception.InvalidTryNumberException;
import racingcargame.view.InputView;
import racingcargame.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGameApplication {
    public static void main(String[] args) {
        Cars cars = inputCars();

        TryNumber tryNumber = inputTryNumber();

        List<RacingGameResult> results = doMoveCycle(cars, tryNumber);

        OutputView.printAllPositions(results);

        Winners winners = new Winners(cars.extractWinners());
        OutputView.printWinners(winners);
    }

    private static Cars inputCars() {
        try {
            String inputCarNames = InputView.inputCarNames();
            return Cars.create(inputCarNames);
        } catch (CarsNameInputException e) {
            OutputView.printErrorMessage(e.getType());
        } catch (CarNameInputException e) {
            OutputView.printErrorMessage(e.getType());
        }
        return inputCars();
    }

    private static TryNumber inputTryNumber() {
        try {
            String tryNumberInput = InputView.inputTryNumber();
            return new TryNumber(tryNumberInput);
        } catch (NumberFormatException e) {
            OutputView.printNotNumberFormatErrorMessage();
        } catch (InvalidTryNumberException e) {
            OutputView.printInvalidTryNumberErrorMessage();
        }
        return inputTryNumber();
    }

    private static List<RacingGameResult> doMoveCycle(Cars cars, TryNumber tryNumber) {
        List<RacingGameResult> results = new ArrayList<>();
        while (tryNumber.next()) {
            cars.move();
            results.add(new RacingGameResult(cars));
        }
        return results;
    }
}
