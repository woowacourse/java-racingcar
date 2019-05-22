package racingcargame.controller;

import racingcargame.view.OutputView;
import racingcargame.model.*;
import racingcargame.view.InputView;

import java.util.*;

public class RacingGame {
    private Turns totalTurns;

    public void play() {
        Cars cars = generateCars();
        getTotalTurns();

        Cars resultCars = doTheTurns(cars);
        Winners winners = new Winners(resultCars);

        OutputView.printWinners(winners);
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

    private Cars doTheTurns(Cars cars) {
        OutputView.printResultSentence();
        Cars resultCars = cars.cloneCars();
        for (int currentTurn = 0; currentTurn < totalTurns.getTurns(); currentTurn++) {
            List<Integer> randomNumbers = generateRandomNumbers(cars.getSize());
            resultCars = resultCars.moveTheCars(randomNumbers);
            OutputView.printCarMovements(resultCars);
        }
        return resultCars;
    }

    private List<Integer> generateRandomNumbers(int size) {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int currentRandom = (int) (Math.random() * 10);
            randomNumbers.add(currentRandom);
        }
        return randomNumbers;
    }
}
