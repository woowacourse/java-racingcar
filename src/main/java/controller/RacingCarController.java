package controller;

import java.util.List;
import model.Car;
import model.Cars;
import utils.Converter;
import model.MovesGenerator;
import view.RetryOnException;
import view.InputView;
import view.OutputView;
import view.dto.CarDto;

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
        Cars cars = RetryOnException.retryInputOnIllegalArgumentException(() -> new Cars(createCars()));
        int tryNumber = RetryOnException.retryInputOnIllegalArgumentException(inputView::inputTryNumber);
        race(tryNumber, cars);
        outputView.printWinner(Converter.convertCarToCarDtos(cars.findWinners()));
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
            List<Boolean> moves = movesGenerator.generate(cars.getCarsSize());
            cars.moveCars(moves);
            List<CarDto> carDtos = cars.convertCarsToCarDtos();
            outputView.printTotalResult(carDtos);
        }
    }
}
