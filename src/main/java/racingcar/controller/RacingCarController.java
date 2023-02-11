package racingcar.controller;

import racingcar.RandomNumberGenerator;
import racingcar.model.Car;
import racingcar.model.RacingCars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.*;
import java.util.stream.Collectors;

public class RacingCarController {

    private static final int START_POSITION = 0;

    private OutputView outputView = OutputView.getInstance();
    private InputView inputView = InputView.getInstance();
    private RacingCars racingCars;

    public void run() {
        String[] carNames = readCarNamesStep();
        injectRacingCarsStep(carNames);
        int tryNum = getTryNum();

        race(tryNum);
        showWinners();
    }

    private String[] readCarNamesStep() {
        outputView.printReadCarNamesMessage();
        String[] carNames = inputView.readCarNames();
        return carNames;
    }

    private void injectRacingCarsStep(String[] carNames) {
        racingCars = new RacingCars(generateCars(carNames));
    }

    private List<Car> generateCars(String[] carNames) {
        return Arrays.stream(carNames)
                .map(carName -> new Car(carName, START_POSITION))
                .collect(Collectors.toUnmodifiableList());
    }

    private void showWinners() {
        List<String> winners = convertWinnersNameForPrint(racingCars.getWinners());
        outputView.printWinners(winners);
    }

    private void race(int tryNum) {
        outputView.printRacingResultMessage();
        for (int repeatIndex = 0; repeatIndex < tryNum; repeatIndex++) {
            List<Car> currentCars = racingCars.getCars();
            for (Car currentCar : currentCars) {
                int randomValue = RandomNumberGenerator.generate();
                currentCar.move(currentCar.canMoving(randomValue));
            }
            outputView.printCurrentRacingCarsPosition(convertRacingCarsResultForPrint(currentCars));
        }
    }

    private int getTryNum() {
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
