package racingcar.controller;

import racingcar.domain.*;
import racingcar.domain.car.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGame {
    public static void main(String[] args) {
        Cars cars = InputView.inputCarNames();
        Round round = InputView.inputRoundNumber();

        System.out.println("실행 결과");
        playRounds(cars, round);

        System.out.println("우승자 명단");
        Winners winners = new Winners(cars);
        OutputView.printResult(winners.getWinnerNames());
    }

    private static void playRounds(Cars cars, Round round) {
        String result;
        while (round.reduceRounds()) {
            cars.play();
            result = cars.getResult();
            OutputView.printResult(result);
            System.out.println();
        }
    }
}