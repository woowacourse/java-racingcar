package controller;

import domain.Car;
import domain.CarRepository;
import domain.Referee;
import util.NumberGenerator;
import util.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class RacingController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final CarRepository carRepository = new CarRepository();
    private final NumberGenerator numberGenerator = new RandomNumberGenerator();
    private final Referee referee = new Referee();

    private static final int START_INDEX = 0;

    public void play() {
        inputCars();
        MoveNTimes(inputTryCount());
        winners();
    }

    public void inputCars() {
        String[] carNames = inputCarNames();
        for (String carName : carNames) {
            carRepository.addCar(new Car(carName));
        }
    }

    private void MoveNTimes(int tryCount) {
        outputView.newLine();
        outputView.resultMessage();
        for (int index = START_INDEX; index < tryCount; index++) {
            move();
            printStatus();
        }
    }

    private void move() {
        carRepository.moveAll(numberGenerator);
    }

    private void winners() {
        CarRepository winnerCarRepository = referee.judgment(carRepository);
        outputView.printWinners(winnerCarRepository);
    }

    private void printStatus() {
        outputView.printStatus(carRepository);
        outputView.newLine();
    }

    private String[] inputCarNames() {
        try {
            outputView.printStartMessage();
            return inputView.inputCarName();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputCarNames();
        }
    }

    private int inputTryCount() {
        outputView.printCountMessage();
        return inputView.inputCount();
    }

}
