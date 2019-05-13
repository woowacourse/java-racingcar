package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class RacingController {

    public static void main(String[] args) {
        Race race = setRace();
        OutputView.outputGameResultTile();
        while (race.hasNextRound()) {
            printEachCarsOnRace(race.moveAllCarsByRoundCount());
        }
        Winners winners = new Winners(race.getCarsOnFinishedRace());
        OutputView.outputWinners(winners.getRaceWinners());
    }

    public static Race setRace() {
        try {
            return new Race(InputView.inputCarNames(), setRoundCount());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setRace();
        }
    }

    public static int setRoundCount() {
        try {
            int roundCount = InputView.inputRoundCount();
            if (roundCount <= Const.ZERO) {
                throw new IllegalArgumentException();
            }
            return roundCount;
        } catch (Exception e) {
            System.out.println(Const.EX_ROUND_COUNT);
            return setRoundCount();
        }
    }

    public static void printEachCarsOnRace(List<Car> carsOnRace) {
        for (Car car : carsOnRace) {
            OutputView.outputGameResult(car.toString());
        }
        System.out.println();
    }
}
