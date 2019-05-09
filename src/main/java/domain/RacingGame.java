package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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
            car.printCurrentPosition();
        }
    }

    private void race() {
        System.out.println("실행 결과");

        for (int i = 1; i <= gameRound; i++) {
            raceByRound();
            printPositionByRound();
            System.out.println();
        }
    }

    private void outputWinners() {
        Winners winners = new Winners();
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
