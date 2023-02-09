package controller;

import java.util.List;
import model.Car;
import model.CarRepository;
import view.InputView;
import view.OutputView;

public class MainController {

    private final InputView inputView;
    private final OutputView outputView;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        try {
            setCars();
            moveCars();
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
        }
    }

    private void moveCars() {
        int moveCount = inputView.readMoveCount();
        outputView.printResultMessage();
        moveAllCars(moveCount);
        outputView.printWinners(CarRepository.getWinners());
    }

    private void setCars() {
        List<String> carNames = inputView.readCarNames();
        carNames.stream().map(Car::new).forEach(CarRepository::addCars);
    }

    private void moveAllCars(int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            CarRepository.moveAllCars();
            outputView.printResult(CarRepository.cars());
        }
    }
}
