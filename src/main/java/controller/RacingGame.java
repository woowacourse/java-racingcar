package controller;

import domain.car.Car;
import domain.car.Cars;
import domain.car.Engine;
import domain.name.Names;
import domain.race.RaceCount;
import domain.race.RaceProgress;
import domain.race.RaceResult;
import view.InputView;
import view.OutputView;

import java.util.List;

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

    private void racing(final List<Car> cars, final Integer raceCount) {
        outputView.printResultMessage();
        for (int i = 0; i < raceCount; i++) {
            racePerRound(cars);
        }
    }

    private void racePerRound(List<Car> cars) {
        race(cars);
        RaceProgress result = RaceProgress.from(cars);
        outputView.printRaceProgressPerRound(result.getRaceCarInfos());
    }

    private void race(final List<Car> cars) {
        cars.forEach(car -> car.race(new Engine()));
    }

    private void finish(final List<Car> cars) {
        RaceResult raceResult = RaceResult.findWinner(cars);
        outputView.printRaceResult(raceResult);
    }
}
