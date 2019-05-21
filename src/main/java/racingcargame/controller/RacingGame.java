package racingcargame.controller;

import racingcargame.view.OutputView;
import racingcargame.model.*;
import racingcargame.view.InputView;

import java.util.*;

public class RacingGame {
    private Turns totalTurns;

    public void play() {
        //get necessary information
        Cars cars = generateCars();
        getTotalTurns();

        //do the game
        Cars resultCars = doTheTurns(cars);
        Winners winners = new Winners(cars);

        List<String> winnersNames = winners.getWinnersNames();
        OutputView.printWinners(winnersNames);
    }

    private Cars generateCars() {
        try {
            String carNames = InputView.askCarNames();
            carNames = carNames.replaceAll(" ","");
            return new Cars(carNames);
        } catch (Exception e) {
            System.out.println("자동차 이름 중에 잘못된 이름이 있습니다!");
            return generateCars();
        }

    }

    private void getTotalTurns() {
        try {
            String input = InputView.askTotalTurns();
            Turns totalTurns = new Turns(input);
            this.totalTurns = totalTurns;
        } catch(Exception e) {
            System.out.println("잘못된 입력입니다");
            getTotalTurns();
        }
    }

    private void doTheTurns(List<Car> cars) {
        OutputView.printResultSentence();
        for (int currentTurn = 0; currentTurn < totalTurns.getTurns(); currentTurn++) {
            cars.moveTheCars();
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

}
