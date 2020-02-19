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

        Winners winners = new Winners(cars.getCars());
        System.out.println("우승자 명단");
        OutputView.printWinners(winners);
    }

    private static void playRounds(Cars cars, Round round) {
        while (round.canGo()) {
            round.reduce();
            cars.play();
            OutputView.printResult(cars);
        }
    }
}