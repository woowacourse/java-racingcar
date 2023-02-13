package racingcar.controller;

import racingcar.util.NumberGenerator;
import racingcar.model.Car;
import racingcar.model.RacingCars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.*;
import java.util.stream.Collectors;

public class RacingCarController {

    private static final int START_POSITION = 0;

    private final OutputView outputView;
    private final InputView inputView;
    private final NumberGenerator numberGenerator;

    public RacingCarController(final NumberGenerator numberGenerator) {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        String[] carNames = readCarNamesStep();
        RacingCars racingCars = generateRacingCarsStep(carNames);
        int tryNum = readTryNumStep();
        race(tryNum, racingCars);
        showWinners(racingCars);
    }

    private String[] readCarNamesStep() {
        outputView.printReadCarNamesMessage();
        String[] carNames = inputView.readCarNames();
        return carNames;
    }

    private RacingCars generateRacingCarsStep(String[] carNames) {
        List<Car> cars = generateCars(carNames);
        return new RacingCars(cars);
    }

    private List<Car> generateCars(String[] carNames) {
        return Arrays.stream(carNames)
                .map(carName -> new Car(carName, START_POSITION))
                .collect(Collectors.toUnmodifiableList());
    }

    private void showWinners(RacingCars racingCars) {
        List<String> winners = convertWinnersNameForPrint(racingCars.getWinners());
        outputView.printWinners(winners);
    }

    private void race(int tryNum, RacingCars racingCars) {
        outputView.printRacingResultMessage();
        for (int repeatIndex = 0; repeatIndex < tryNum; repeatIndex++) {
            List<Car> currentCars = racingCars.getCars();
            for (Car currentCar : currentCars) {
                int randomValue = numberGenerator.generate();
                currentCar.move(currentCar.canMoving(randomValue));
            }
            outputView.printCurrentRacingCarsPosition(convertRacingCarsResultForPrint(currentCars));
        }
    }

    private int readTryNumStep() {
        outputView.printReadTryNumMessage();
        return inputView.readTryNum();
    }

    private Map<String, Integer> convertRacingCarsResultForPrint(List<Car> currentCars) {
        Map<String, Integer> racingCarsResult = new HashMap<>();
        for (Car currentCar : currentCars) {
            racingCarsResult.put(currentCar.getName(), currentCar.getPosition());
        }
        return racingCarsResult;
    }

    private List<String> convertWinnersNameForPrint(List<Car> winners) {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
