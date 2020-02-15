package racingcar.controller;

import jdk.internal.util.xml.impl.Input;
import racingcar.domain.*;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarGame {
    public static void main(String[] args) {
        String inputForCarNames = InputView.inputCarNames();
        List<Car> cars = Cars.generateCarsByInput(inputForCarNames);

        Round round = inputRound();

        System.out.println("실행 결과");
        playRounds(cars, round);

//        System.out.println("우승자 명단");
//        Winners winners = new Winners(cars);
//        OutputView.printResult(winners.getWinnersName());
    }

    private static List<Car> inputCarNames() {
        try {
            String inputForCarNames = InputView.inputCarNames();
            return Cars.generateCarsByInput(inputForCarNames);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return inputCarNames();
        }
    }

    private static Round inputRound() {
        try {
            String inputForRound = InputView.inputRound();
            return new Round(inputForRound);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return inputRound();
        }
    }

    private static void playRounds(List<Car> cars, Round round) {
        String roundResult;
        while(round.isGoing()) {
            Cars.play(cars);
            roundResult = Cars.getRoundResult(cars);
            OutputView.printResult(roundResult);
            System.out.println();
        }
    }
}