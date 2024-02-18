package controller;

import domain.car.Car;
import domain.car.Cars;
import constant.CarConstant;
import domain.name.Names;
import domain.race.RaceCount;
import domain.race.RaceProgress;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGame() {
        Cars cars = registerCars();

        RaceCount raceCount = inputView.inputRaceCount();

        performRace(cars.getValue(), raceCount.getValue());

        announceWinners(cars);
    }

    private Cars registerCars() {
        Names names = inputView.inputCarNameCatalog();
        return Cars.from(names);
    }

    private void performRace(final List<Car> cars, Integer raceCount) {
        List<RaceProgress> raceProgresses = new ArrayList<>();
        for (int i = 0; i < raceCount; i++) {
            performEachRace(cars);
            raceProgresses.add(RaceProgress.from(cars));
        }

        outputView.printAllRaceProgress(raceProgresses);
    }

    private void performEachRace(final List<Car> cars) {
        cars.forEach(car -> {
            Integer power = createPower();
            car.race(power);
        });
    }

    private void announceWinners(Cars cars) {
        outputView.printRaceResult(cars);
    }

    private Integer createPower() {
        return new Random().nextInt(CarConstant.MAXIMUM_POWER);
    }
}