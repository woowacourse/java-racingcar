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
		Cars cars = inputView.askCars();
		Trial trial = inputView.askTrial();
		for (int i = 0; i < trial.getTrial(); i++) {
			printRound(cars);
		}
		outputView.printWinner(new Winner(cars));
	}

	private void printRound(Cars cars) {
		for (int j = 0; j < cars.getCarsSize(); j++) {
			cars.addDistance(RandomNumberMaker.makeNumber(), j);
		}
		outputView.printCarsDistance(cars);
	}
}
