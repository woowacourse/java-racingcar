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
        Cars cars = new Cars(inputView.askCarNames());
        Trial trial = new Trial(inputView.askTrial());
        doRace(cars, trial);
        outputView.printWinner(new Winner(cars));
    }

    private void doRace(Cars cars, Trial trial) {
        while (trial.isRemainTrial()) {
            trial.doTryOne();
            cars.addDistance(RandomNumberMaker.makeNumber(cars.getCarsSize()));
            outputView.printCarsDistance(cars);
        }
    }

}
