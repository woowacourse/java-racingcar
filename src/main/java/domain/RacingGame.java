package domain;

import utils.InputUtil;
import utils.OutputUtil;
import utils.RandomUtil;

import java.util.ArrayList;

public class RacingGame {
    private ArrayList<String> carNames;
    private int gameRound;
    private ArrayList<Car> carList = new ArrayList<>();

    private void input() {
        carNames = InputUtil.inputNames();
        gameRound = InputUtil.inputRound();
    }

    private void registerCars() {
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
    }

    private void raceByRound() {
        for (Car car : carList) {
            car.move(RandomUtil.randomNumber());
        }
    }

    private void printPositionByRound() {
        for (Car car : carList) {
            car.printPosition();
        }
    }

    private void race() {
        OutputUtil.printMessage("실행 결과");

        for (int i = 1; i <= gameRound; i++) {
            raceByRound();
            printPositionByRound();
            System.out.println();
        }
    }

    private void outputWinners() {
        WinnerCars winners = new WinnerCars();
        winners.determineWinners(carList);
        winners.printWinners();
    }

    public void run() {
        input();
        registerCars();
        race();
        outputWinners();
    }
}
