package controller;

import java.util.List;
import model.Car;
import model.Cars;
import utils.MovesGenerator;
import utils.Retry;
import view.InputView;
import view.OutputView;

public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;
    private final MovesGenerator movesGenerator;

    public RacingCarController(InputView inputView, OutputView outputView, MovesGenerator movesGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.movesGenerator = movesGenerator;
    }

    public void run() {
        List<String> carNames = Retry.retryOnException(inputView::inputCarNames);
        Cars cars = new Cars(createCars(carNames));
        int tryNumber = Retry.retryOnException(inputView::inputTryNumber);
        race(tryNumber, cars);
        outputView.printWinner(cars.findWinners());
    }

    private List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    private void race(int tryNumber, Cars cars) {
        outputView.printResultHeader();
        for (int i = 0; i < tryNumber; i++) {
            List<Boolean> moves = movesGenerator.generate(cars.getCarsSize());
            cars.moveCars(moves);
            String totalMovementDetails = cars.getTotalMovementDetails();
            outputView.printResult(totalMovementDetails);
        }
    }
}
