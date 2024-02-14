package controller;

import java.util.List;
import model.Car;
import model.Cars;
import utils.RandomNumberGenerator;
import utils.Retry;
import view.InputView;
import view.OutputView;

public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RandomNumberGenerator generator;

    public RacingCarController(InputView inputView, OutputView outputView, RandomNumberGenerator generator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.generator = generator;
    }

    public void run(){
        List<String> carNames = Retry.retryOnException(inputView::inputCarNames);
        Cars cars = new Cars(createCars(carNames));
        int tryNumber = Retry.retryOnException(inputView::inputTryNumber);
        startRacing(tryNumber, cars);
        outputView.printWinner(cars.findWinners());
    }

    private List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    private void startRacing(int tryNumber, Cars cars) {
        outputView.printResultHeader();
        for (int i=0; i<tryNumber; i++) {
            List<Integer> randomMoveNumbers = generator.generate(cars.getCarsSize());
            cars.moveCars(randomMoveNumbers);
            String totalMovementDetails = cars.getTotalMovementDetails();
            outputView.printResult(totalMovementDetails);
        }
    }
}
