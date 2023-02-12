package controller;

import domain.Cars;
import view.InputView;
import view.OutputView;

public class Controller {
    OutputView outputView;
    Cars cars = new Cars();
    final String[] carNames;
    final int tryCount;
    private static final int START_INDEX = 0;

    public Controller(InputView inputView, OutputView outputView) {
        this.carNames = inputView.inputCarsName();
        this.tryCount = inputView.inputCount();
        this.outputView = outputView;
    }

    public void race() {
        cars.creatCar(carNames);
        playGame(tryCount);
        outputView.printWinners(cars.selectWinners());
    }

    public void playGame(int count) {
        for (int index = START_INDEX; index < count; index++) {
            outputView.printAllStatus(cars.powerInjectionAllCars());
        }
    }
}
