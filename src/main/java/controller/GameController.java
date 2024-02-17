package controller;

import domain.car.Car;
import domain.car.Cars;
import domain.car.constant.CarConstant;
import domain.name.Names;
import domain.race.RaceCount;
import domain.race.RaceProgress;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        Cars cars = register();

        RaceCount raceCount = inputView.inputRaceCount();

        racing(cars.getValue(), raceCount.getValue());

        finish(cars);
    }

    private Cars register() {
        Names names = inputView.inputCarNameCatalog();
        return Cars.from(names);
    }

    private void racing(final List<Car> cars, Integer raceCount) {
        List<RaceProgress> raceProgresses = IntStream.range(0, raceCount)
                                                     .mapToObj(i -> {
                                                         race(cars);
                                                         return RaceProgress.from(cars);
                                                     })
                                                     .toList();
        outputView.printAllRaceProgress(raceProgresses);
    }

    private void race(final List<Car> cars) {
        cars.forEach(car -> {
            Integer power = createPower();
            car.race(power);
        });
    }

    private void finish(Cars cars) {
        outputView.printRaceResult(cars);
    }

    private Integer createPower() {
        return new Random().nextInt(CarConstant.MAXIMUM_POWER);
    }
}