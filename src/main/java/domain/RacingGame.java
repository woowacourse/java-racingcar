package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RacingGame {
    public static Scanner sc = new Scanner(System.in);
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
        //예외
        gameRound = Integer.parseInt(round);
    }

    private void registerCars() {
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
    }

    private void raceByRound() {
        for (Car car : carList) {
            car.move(randomNumber());
        }
    }

    public void printPositionByRound() {
        for (Car car : carList) {
            car.printCurrentPosition();
        }
    }

    private int randomNumber() {
        return (int) (Math.random() * Constant.RANDOM_NUMBER_RANGE);
    }
}
