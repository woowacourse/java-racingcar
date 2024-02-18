package controller;

import domain.Car;
import domain.Cars;
import domain.Judge;
import domain.Round;
import util.Exceptions;
import util.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

import java.util.List;

public class CarRacingGame {

    private final InputView inputView;
    private final OutputView outputView;
    private final Judge judge;

    public CarRacingGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.judge = new Judge();
    }

    public void play() {
        try {
            Cars cars = createCars();
            Round round = createRound();

            outputView.printResultMessage();
            race(cars, round);

            printWinners(cars);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void race(Cars cars, Round round) {
        for (int i = 0; i < round.getCount(); i++) {
            moveCars(cars);
            printMovement(cars);
        }
    }

    private void moveCars(Cars cars) {
        for (Car car : cars.getCars()) {
            car.move(RandomNumberGenerator.generate());
        }
    }

    private void printMovement(Cars cars) {
        for (Car car : cars.getCars()) {
            outputView.printMovement(car.getName(), car.getForward());
        }
        System.out.println();
    }

    private Cars createCars() {
        String rawNames = inputView.inputCarNames();
        validateIsNull(rawNames);
        List<String> names = List.of(rawNames.split(","));

        return new Cars(names);
    }

    private Round createRound() {
        String rawRap = inputView.inputRap();
        validateIsNull(rawRap);
        int rap = convertToInt(rawRap);

        return new Round(rap);
    }

    private void validateIsNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(Exceptions.NULL_EXCEPTION.getMessage());
        }
    }

    private int convertToInt(String rawRap) {
        validateNumberFormat(rawRap);
        return Integer.parseInt(rawRap);
    }

    private void validateNumberFormat(String rawRap) {
        try {
            Integer.parseInt(rawRap);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Exceptions.NUMBER_FORMAT_EXCEPTION.getMessage());
        }
    }

    private void printWinners(Cars cars) {
        List<String> winners = judge.findWinners(cars);
        outputView.printWinners(winners);
    }

}
