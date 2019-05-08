package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RacingGame {
    private static Scanner sc = new Scanner(System.in);
    private ArrayList<String> carNames;
    private int gameRound;
    private ArrayList<Car> carList;

    private String input() {
        return sc.nextLine();
    }

    private void inputNames() {
        String names = input();
        carNames = new ArrayList<>(Arrays.asList(names.split(",")));
    }

    private void inputRound() {
        String round = input();
        //예외처리
        gameRound = Integer.parseInt(round);
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
        for (int i = 1; i <= gameRound; i++) {
            raceByRound();
            printPositionByRound();
        }
    }


}
