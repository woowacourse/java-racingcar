package controller;

import domain.Cars;
import domain.Trial;
import domain.Winner;
import view.InputView;
import view.OutputView;

public class Controller {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        Cars cars = askCars();
        Trial trial = askTrial();
        for (int j = 0; j < trial.getTrial(); j++) {
            cars.addDistance();
            outputView.printCarsDistance(cars);
        }
        outputView.printWinner(new Winner(cars));
    }


    private Cars askCars() {
        try {
            return new Cars(inputView.askCars());
        } catch (IllegalArgumentException e) {
            return askCars();
        }
    }

    private Trial askTrial() {
        try {
            return new Trial(inputView.askTrial());
        } catch (IllegalArgumentException e) {
            return askTrial();
        }
    }
}
