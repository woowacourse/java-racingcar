package controller;

import domain.Car;
import domain.Cars;
import service.RacingCarService;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static util.Exceptions.NULL_EXCEPTION;

public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingCarService racingCarService;

    public RacingCarController(RacingCarService racingCarService, InputView inputView, OutputView outputView) {
        this.racingCarService = racingCarService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {

    }

    private Cars getCars() {
        String carsName = inputView.inputCarsName();

        validateIsNull(carsName);

        return null;
    }

    private int getCount() {
        String count = inputView.inputCount();

        validateIsNull(count);

        return racingCarService.getCount(count);
    }

    private void validateIsNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(NULL_EXCEPTION.getMessage());
        }
    }

    private void printMovement(Cars cars) {
        List<String> movement = racingCarService.getMovement(cars);
        outputView.printMovement(movement);
    }

    private void printWinners(Cars cars) {
        List<String> winners = racingCarService.findWinners(cars);
        outputView.printWinners(winners);
    }

}
