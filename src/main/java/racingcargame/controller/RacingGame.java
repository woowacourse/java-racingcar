package racingcargame.controller;

import racingcargame.view.OutputView;
import racingcargame.model.*;
import racingcargame.view.InputView;

import java.util.*;

public class RacingGame {
    private int totalTurns = 0;

    public void play() {
        List<Car> cars = makeCars();
        getTotalTurns();
        doTheTurns(cars);
        //List<Car> winners = decideWinners(cars);
        Winners winners = new Winners(cars);
        List<String> winnersNames = winners.getWinnersNames();
        OutputView.printWinners(winnersNames);
    }


    private void doTheTurns(List<Car> cars) {
        System.out.println("실행결과: ");
        for (int currentTurn = 0; currentTurn < totalTurns; currentTurn++) {
            doOneTurn(cars);
        }
    }

    private void doOneTurn(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = RandomNumberGenerator.generateRandomNumber();
            car.updateCarPosition(randomNumber);
            String carState = car.getCarState();
            OutputView.printCarState(carState);
        }
        OutputView.printLineChange();
    }

    private static List<Car> makeCars() {
        try {
            String carNames = InputView.askCarNames();
            List<Car> cars = CarsGenerator.makeCars(carNames);
            return cars;
        } catch (Exception e) {
            System.out.println("잘못된 차이름이 있습니다!");
            return makeCars();
        }
    }

    private void getTotalTurns() {
        try {
            String input = InputView.askTotalTurns();
            int totalTurns = TurnsGenerator.makeTurns(input);
            this.totalTurns = totalTurns;
        } catch(Exception e) {
            System.out.println("잘못된 입력입니다");
            getTotalTurns();
        }
    }

}
