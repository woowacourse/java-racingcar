package controller;

import domain.car.Car;
import domain.car.Cars;
import domain.name.Names;
import domain.race.RaceCount;
import domain.race.RaceProgress;
import domain.race.RaceResult;
import util.NumberGenerator;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.stream.IntStream;

public class RacingGame {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        Cars cars = register();

        RaceCount raceCount = inputView.inputRaceCount();

        racing(cars.getValue(), raceCount.getValue());

        finish(cars.getValue());
    }

    private Cars register() {
        Names names = inputView.inputCarNameCatalog();
        return Cars.from(names);
    }

    private void racing(final List<Car> cars,final Integer raceCount) {
        List<RaceProgress> raceProgresses = IntStream.range(0, raceCount)
                .mapToObj(i -> {
                    race(cars);
                    return RaceProgress.from(cars);
                })
                .toList();
        outputView.printRaceProgresses(raceProgresses);
    }

    private void race(final List<Car> cars) {
        cars.forEach(car -> car.race(NumberGenerator.generate(Car.FORWARD_MAX_NUMBER)));
    }

    private void finish(final List<Car> cars) {
        RaceResult raceResult = RaceResult.from(cars);
        outputView.printRaceResult(raceResult);
    }
}
