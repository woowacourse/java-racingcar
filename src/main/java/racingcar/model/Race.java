package racingcar.model;

import racingcar.view.OutputView;

public class Race {
    private final Cars cars;
    private final int tryNumber;
    private final OutputView outputView = new OutputView();

    public Race(Cars cars, int tryNumber) {
        this.cars = cars;
        this.tryNumber = tryNumber;
    }

    public void runRace() {
        outputView.printResultHeaderPrompt();
        for (int i = 0; i < tryNumber; i++) {
            runEachRaceAndPrintResult();
        }
    }

    private void runEachRaceAndPrintResult() {
        cars.moveAllCars();
        cars.getCars()
                .forEach(car -> outputView.printResult(car.getName(), car.getPosition()));
        OutputView.parseLine();
    }

    public void printWinners() {
        Referee referee = new Referee();
        outputView.printWinners(referee.determineWinnerNames(cars));
    }
}