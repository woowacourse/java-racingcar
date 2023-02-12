package controller;

import domain.Cars;
import domain.Trial;
import domain.Winner;
import util.RandomNumberMaker;
import view.InputView;
import view.OutputView;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        Cars cars = inputView.askCarNames();
        Trial trial = inputView.askTrial();
        for (int j = 0; j < trial.getTrial(); j++) {
            cars.addDistance(RandomNumberMaker.makeNumber(cars.getCarsSize()));
            outputView.printCarsDistance(cars);
        }
        outputView.printWinner(new Winner(cars));
    }

}
