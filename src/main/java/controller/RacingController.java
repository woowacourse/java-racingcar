package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class RacingController {

    public static void main(String[] args) {
        Race race = new Race(setCarsOnRace(), setRoundCount());
        Winners winners = new Winners(race.moveAllCarsByRoundCount());
        OutputView.outputGameResultTile();
        OutputView.outputGameResult(race.toString());
        OutputView.outputWinners(winners.getRaceWinners());
    }

    private static List<Car> setCarsOnRace() {
        try {
            Cars cars = new Cars(InputView.inputCarNames());
            return cars.createCars();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setCarsOnRace();
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
}
