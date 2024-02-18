package controller;

import java.util.List;
import model.Car;
import model.Cars;
import view.InputView;
import view.OutputView;
import view.RetryOnException;

public class RacingCarController {
    private final OutputView outputView;

    public RacingCarController(OutputView outputView) {
        this.outputView = outputView;
    }

    public void run() {
        Cars cars = RetryOnException.retryInputOnIllegalArgumentException(() -> new Cars(createCars()));
        int tryNumber = RetryOnException.retryInputOnIllegalArgumentException(InputView::inputTryNumber);
        race(tryNumber, cars);
        List<Car> winners = cars.findWinners();
        List<String> winnerNames = winners.stream().map(Car::getCarName).toList();
        outputView.printWinner(winnerNames);
    }

    private List<Car> createCars() {
        List<String> carNames = InputView.inputCarNames();
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    private void race(int tryNumber, Cars cars) {
        outputView.printResultHeader();
        for (int i = 0; i < tryNumber; i++) {
            cars.moveCars();
            outputView.printTotalResult(cars.getCars());
        }
    }
}
