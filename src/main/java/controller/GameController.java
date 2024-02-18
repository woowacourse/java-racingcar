package controller;

import domain.car.Car;
import domain.car.Cars;
import domain.name.Names;
import domain.race.RaceCount;
import domain.race.RaceProgress;
import util.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    private final RandomNumberGenerator randomNumberGenerator;

    public GameController(InputView inputView, OutputView outputView, RandomNumberGenerator randomNumberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.randomNumberGenerator = randomNumberGenerator;

    }

    public void startGame() {
        Cars cars = registerCars();

        RaceCount raceCount = inputView.inputRaceCount();

        performRace(cars, raceCount.getValue());

        announceWinners(cars);
    }

    private Cars registerCars() {
        Names names = inputView.inputCarNameCatalog();
        return Cars.from(names);
    }

    private void performRace(final Cars cars, Integer raceCount) {
        List<RaceProgress> raceProgresses = cars.performRace(raceCount, randomNumberGenerator);
        outputView.printAllRaceProgress(raceProgresses);
    }

    private void announceWinners(Cars cars) {
        outputView.printRaceResult(cars);
    }

}
