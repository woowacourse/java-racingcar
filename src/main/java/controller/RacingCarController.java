package controller;

import domain.Car;
import domain.Cars;
import java.util.List;
import view.InputView;
import view.OutputView;
import view.RetryOnException;
import view.dto.CarDto;

public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Cars cars = RetryOnException.retryInputOnIllegalArgumentException(() -> new Cars(createCars()));
        int tryNumber = RetryOnException.retryInputOnIllegalArgumentException(inputView::inputTryNumber);
        race(tryNumber, cars);
        List<Car> winners = cars.findWinners();
        List<String> winnerNames = winners.stream().map(Car::getCarName).toList();
        outputView.printWinner(winnerNames);
    }

    private List<Car> createCars() {
        List<String> carNames = inputView.inputCarNames();
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    private void race(int tryNumber, Cars cars) {
        outputView.printResultHeader();
        for (int i = 0; i < tryNumber; i++) {
            cars.moveCars();
            List<CarDto> carDtos = cars.getPresentCarsStatus().stream().map(CarDto::new).toList();
            outputView.printTotalResult(carDtos);
        }
    }
}
