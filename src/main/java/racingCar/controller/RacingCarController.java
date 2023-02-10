package racingCar.controller;

import racingCar.domain.Cars;
import racingCar.util.NumberPicker;
import racingCar.view.InputView;
import racingCar.view.OutputView;
import java.util.List;
import java.util.function.Supplier;

public class RacingCarController {

    public void run() {
        Cars cars = repeat(this::generateCars);
        Integer tryCount = repeat(InputView::readTryCount);
        playRacing(new NumberPicker(), tryCount, cars);
        OutputView.printWinners(cars.findWinners());
    }

    private Cars generateCars() {
        List<String> carNames = repeat(InputView::readCarNames);
        return new Cars(carNames);
    }

    private void playRacing(NumberPicker numberPicker, int tryCount, Cars cars) {
        for (int i = 0; i < tryCount; i++) {
            cars.moveCars(numberPicker);
            OutputView.printCarPosition(cars.toDtos());
        }
    }

    private static <T> T repeat(Supplier<T> reader) {
        try {
            return reader.get();
        } catch (Exception e) {
            OutputView.printError(e.getMessage());
            return repeat(reader);
        }
    }
}
