package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RandomNum;
import racingcar.util.Validation;
import racingcar.view.Input;
import racingcar.view.Output;

public class CarController {
    private static final String SPLIT_DELIM = ",";

    public CarController() {
    }

    public void play() {
        Cars cars = new Cars(makeCars());
        int tryNum = makeTryNum();

        startRace(cars, tryNum);
        findFinalWinner(cars);
    }

    private static List<Car> makeCars() {
        String names = Input.inputCarNames();

        try {
            Validation.carNameValidation(names);
            List<Car> cars = convertStringList(names);
            return cars;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeCars();
        }
    }

    private static int makeTryNum() {
        String tryValue = Input.inputTry();

        try {
            Validation.tryNumValidation(tryValue);
            return Integer.parseInt(tryValue);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeTryNum();
        }
    }

    private static List<Car> convertStringList(final String names) {
        List<Car> cars = new ArrayList<>();

        for (String carName : names.split(SPLIT_DELIM)) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public static void startRace(final Cars cars, final int tryNum) {
        Output.printResultWord();

        for (int i = 0; i < tryNum; i++) {
            moveCar(cars);
            printRace(cars);
        }
    }

    public static void moveCar(final Cars cars) {
        for (Car car : cars.getCars()) {
            car.goForward(RandomNum.getRandomNum());
        }
    }

    public static void printRace(final Cars cars) {
        Output.printCarsRace(cars);
    }

    public static void findFinalWinner(final Cars cars) {
        Output.printWinner(cars.getWinners());
    }
}
