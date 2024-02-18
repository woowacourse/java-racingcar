package controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import constants.ErrorMessages;
import domain.Car;
import domain.Cars;
import utils.Randoms;
import view.InputView;
import view.OutputView;

public class RacingGame {
    private static final int MAX_RANDOM_NUMBER_RANGE = 9;

    private final InputView inputView;
    private final OutputView outputView;

    public RacingGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String names = retryInputOnException(inputView::receiveNames);
        int trialCount = retryInputOnException(inputView::receiveTrialCount);

        Cars cars = loadCars(names);
        race(trialCount, cars);
        outputView.printWinners(cars);
    }

    private <T> T retryInputOnException(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessages.INVALID_INPUT.getMessage());
            return retryInputOnException(supplier);
        }
    }

    private Cars loadCars(String carNames) {
        List<Car> carList = Arrays.stream(carNames.split(","))
                .map(Car::from)
                .toList();

        return new Cars(carList);
    }

    private void race(int trialCount, Cars cars) {
        outputView.printResultPrefix();
        for (int i = 0; i < trialCount; i++) {
            List<Integer> randomNumbers = createRandomNumber(cars.getCount());
            cars.moveAll(randomNumbers);
            outputView.printCurrentRace(cars);
        }
    }


    protected List<Integer> createRandomNumber(int carCount) {
        return Randoms.getRandomNumbers(carCount, MAX_RANDOM_NUMBER_RANGE);
    }
}
