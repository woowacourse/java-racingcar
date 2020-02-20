package racingcar.controller;

import racingcar.domain.RandomNumber;
import racingcar.domain.Round;
import racingcar.domain.Winners;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGame {
    public static void main(String[] args) {
        Cars cars = inputCarNames();
        Round round = inputRound();

        System.out.println("실행 결과");
        playRounds(cars, round);

        Winners winners = new Winners(cars.getCars());

        OutputView.printWinners(winners);
    }

    private static Round inputRound() {
        try {
            return new Round(InputView.inputRound());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return inputRound();
    }

    private static Cars inputCarNames() {
        try {
            return new Cars(InputView.inputCarNames());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return inputCarNames();
    }

    private static void playRounds(Cars cars, Round round) {
        while (round.canGo()) {
            round.reduce();
            play(cars);
            OutputView.printResult(cars);
        }
    }

    private static void play(Cars cars) {
        RandomNumber randomNumber = new RandomNumber();
        for (Car car : cars.getCars()) {
            car.play(randomNumber.generateNumber());
        }
    }
}