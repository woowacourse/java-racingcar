package controller;

import domain.Cars;
import domain.Trial;
import domain.Winner;
import view.InputView;
import view.OutputView;

public class Controller {
	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();

	public void run() {
		Cars cars = inputView.askCars();
		Trial trial = inputView.askTrial();
		startRacing(cars, trial);
		outputView.printWinner(new Winner(cars));
	}

	private void startRacing(Cars cars, Trial trial) {
		for (int i = 0; i < trial.getTrial(); i++) {
			cars.move();
			outputView.printCarsDistance(cars);
		}
	}
}
