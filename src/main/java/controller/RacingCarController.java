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

    public RacingCarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){
        List<String> carNames = Retry.retryOnException(inputView::inputCarNames);
        Cars cars = new Cars(createCars(carNames));

    }

    private List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(carName -> new Car(carName,new RandomNumberGenerator()))
                .toList();
    }
}
