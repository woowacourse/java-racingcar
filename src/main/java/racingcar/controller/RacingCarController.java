package racingcar.controller;

import racingcar.CarNumberGenerator;
import racingcar.CarRandomNumberGenerator;
import racingcar.model.Car;
import racingcar.model.RacingCars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingCarController {

    private static final int START_POSITION = 0;
    private final CarNumberGenerator carNumberGenerator = new CarRandomNumberGenerator();
    private OutputView outputView = OutputView.getInstance();
    private InputView inputView = InputView.getInstance();
    private RacingCars racingCars;


    public void run() {
        List<Car> cars = generateCars();
        racingCars = new RacingCars(cars);
        int tryNum = getTryNum();

        race(tryNum);
        showWinners();
    }

    private List<Car> generateCars() {
        outputView.printReadCarNamesMessage();
        String[] carNames = inputView.readCarNames();
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName, START_POSITION));
        }
        return cars;
    }

    private int getTryNum() {
        outputView.printReadTryNumMessage();
        return inputView.readTryNum();
    }

    private void race(int tryNum) {
        outputView.printRacingResultMessage();
        for (int repeatIndex = 0; repeatIndex < tryNum; repeatIndex++) {
            List<Car> currentCars = racingCars.getCars();
            racingCars.tryOneTime(carNumberGenerator);
            outputView.printCurrentRacingCarsPosition(convertRacingCarsResultForPrint(currentCars));
        }
    }

    private Map<String, Integer> convertRacingCarsResultForPrint(List<Car> currentCars) {
        Map<String, Integer> racingCarsResult = new HashMap<>();
        for (Car currentCar : currentCars) {
            racingCarsResult.put(currentCar.getName(), currentCar.getPosition());
        }
        return racingCarsResult;
    }

    private void showWinners() {
        List<String> winners = convertWinnersNameForPrint(racingCars.getWinners());
        outputView.printWinners(winners);
    }

    private List<String> convertWinnersNameForPrint(List<Car> winners) {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

}
