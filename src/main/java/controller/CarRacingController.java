package controller;

import domain.Cars;
import domain.Judge;
import service.RacingCarService;
import util.Exceptions;
import view.InputView;
import view.OutputView;

import java.util.List;

public class CarRacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingCarService racingCarService;
    private final Judge judge;

    public CarRacingController(RacingCarService racingCarService, InputView inputView, OutputView outputView, Judge judge) {
        this.racingCarService = racingCarService;
        this.inputView = inputView;
        this.outputView = outputView;
        this.judge = judge;
    }

    public void run() {
        Cars cars = createCars();
        int raps = getCount();

        outputView.printResultMessage();

        race(cars, raps);

        printWinners(cars);
    }

    private void race(Cars cars, int raps) {
        for (int i = 0; i < raps; i++) {
            racingCarService.moveCars(cars);
            printMovement(cars);
        }
    }

    private void printMovement(Cars cars) {
        List<String> movement = racingCarService.getMovement(cars);
        outputView.printCarsMovement(movement);
    }

    private Cars createCars() {
        String rawNames = inputView.inputCarNames();

        validateIsNull(rawNames);

        List<String> names = List.of(rawNames.split(","));

        return racingCarService.createCars(names);
    }

    private int getCount() {
        String count = inputView.inputCount();

        validateIsNull(count);

        return racingCarService.getCount(count);
    }

    private void validateIsNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(Exceptions.NULL_EXCEPTION.getMessage());
        }
    }

    private void printWinners(Cars cars) {
        List<String> winners = judge.findWinners(cars);
        outputView.printWinners(winners);
    }

}
