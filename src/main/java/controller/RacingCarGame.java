package controller;

import domain.Cars;
import util.Exceptions;
import view.InputView;
import view.OutputView;

import java.util.List;


public class RacingCarGame {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        Cars cars = makeCars();
        int count = makeCount();

        outputView.printMovementTitle();

        for (int i = 0; i < count; i++) {
            cars.moveCars();
            outputView.printCurrentStatus(cars.getCurrentStatus());
        }

        outputView.printWinners(cars.findWinners());
    }

    private Cars makeCars() {
        String carsName = inputView.inputCarsName();

        validateIsNull(carsName);

        return new Cars(List.of(carsName.split(",")));
    }

    private void validateIsNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(Exceptions.NULL_EXCEPTION.getMessage());
        }
    }

    private int makeCount() {
        String count = inputView.inputCount();

        validateIsNull(count);
        validateNumberFormat(count);

        int convertedCount = Integer.parseInt(count);
        validateInvalidNumber(convertedCount);

        return convertedCount;
    }

    private void validateNumberFormat(String rawCount) {
        try {
            Integer.parseInt(rawCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Exceptions.NUMBER_FORMAT_EXCEPTION.getMessage());
        }
    }

    private void validateInvalidNumber(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException(Exceptions.NUMBER_RANGE_EXCEPTION.getMessage());
        }
    }

}
