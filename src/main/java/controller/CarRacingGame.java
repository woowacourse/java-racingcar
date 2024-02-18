package controller;

import domain.Car;
import domain.Cars;
import domain.Winners;
import domain.Round;
import util.Exceptions;
import util.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

import java.util.List;

public class CarRacingGame {

    private final InputView inputView;
    private final OutputView outputView;

    public CarRacingGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
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

    private void validateIsNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(Exceptions.NULL_EXCEPTION.getMessage());
        }
    }

    private Round createRound() {
        int round = inputView.inputRound();

        return new Round(round);
    }

    private void printWinners(Cars cars) {
        List<String> winners = Winners.findWinners(cars).getWinners();
        outputView.printWinners(winners);
    }

}
