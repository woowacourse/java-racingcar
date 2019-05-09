package controller;

import domain.Car;
import domain.Race;
import domain.WinnerCars;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;

public class RacingGameController {
    private ArrayList<String> carNames;
    private int gameRound;
    private ArrayList<Car> carList = new ArrayList<>();

    public void run() {
        input();
        registerCars();
        race();
        outputWinners();
    }

    private void input() {
        carNames = InputView.inputNames();
        gameRound = InputView.inputRound();
    }

    private void registerCars() {
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
    }

    private void race() {
        System.out.println("실행 결과");

        for (int i = 1; i <= gameRound; i++) {
            Race.raceByRound(carList);
            OutputView.printPosition(carList);
            System.out.println();
        }
    }

    private void outputWinners() {
        WinnerCars winners = new WinnerCars();
        ArrayList<Car> winnerList = winners.determineWinners(carList);

        OutputView.printWinners(winnerList);
    }
}
