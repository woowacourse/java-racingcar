package controller;

import domain.car.Cars;
import domain.name.Names;
import domain.race.RaceCount;
import domain.race.RaceProgress;
import util.NumberGenerator;
import util.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.stream.IntStream;

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

        performRace(cars, raceCount.getValue());

        announceWinners(cars);
    }

    private Cars registerCars() {
        Names names = inputView.inputCarNameCatalog();
        return Cars.from(names);
    }

    //TODO : NumberGenerator 를 주입할 지 , 내부 생성할지 좀 더 고려해봐야함
    private void performRace(final Cars cars, Integer raceCount) {
        NumberGenerator powerGenerator = new RandomNumberGenerator();
        List<RaceProgress> raceProgresses = IntStream.range(0, raceCount)
                                                     .mapToObj(value -> performEachRace(cars, powerGenerator))
                                                     .toList();
        outputView.printAllRaceProgress(raceProgresses);
    }

    private RaceProgress performEachRace(final Cars cars, NumberGenerator powerGenerator) {
        cars.performRace(powerGenerator);
        return cars.convertRaceProgress();
    }

    private void announceWinners(Cars cars) {
        outputView.printRaceResult(cars);
    }

}
