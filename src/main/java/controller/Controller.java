package controller;

import domain.Cars;
import domain.Trial;
import domain.Winner;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Scanner scanner = new Scanner(System.in);


    public void run() {
        Cars cars = askCars();
        Trial trial = askTrial();
        for (int j = 0; j < trial.getTrial(); j++) {
            cars.addDistance();
            outputView.printCarsDistance(cars);
        }
        outputView.printWinner(new Winner(cars));
        scanner.close();
    }


    private Cars askCars() {
        try {
            return new Cars(inputView.askCars(scanner));
        } catch (IllegalArgumentException e) {
            return askCars();
        }
    }

    private Trial askTrial() {
        try {
            return new Trial(inputView.askTrial(scanner));
        } catch (IllegalArgumentException e) {
            return askTrial();
        }
    }
}
