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
        Cars cars = getCars();
        int count = getCount();

        outputView.printMovementTitle();

        race(cars, count);

        printWinners(cars);
    }

    private void race(Cars cars, int count) {
        for (int i = 0; i < count; i++) {
            racingCarService.moveCars(cars);
            printMovement(cars);
        }
    }

    private void printMovement(Cars cars) {
        List<String> movement = racingCarService.getMovement(cars);
        outputView.printCarsMovement(movement);
    }

    private Cars getCars() {
        String carsName = inputView.inputCarsName();

        validateIsNull(carsName);

        return racingCarService.getCars(carsName);
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
