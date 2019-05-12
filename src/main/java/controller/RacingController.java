package controller;

import domain.*;
import util.Util;
import view.InputView;
import view.OutputView;

import java.util.List;

public class RacingController {

    public static void main(String[] args) {
        Race race = new Race(setCarsOnRace(), setRoundCount());
        Winners winners = new Winners(race.moveAllCarsByRoundCount());
        OutputView.outputGameResultTile();
        OutputView.outputWinners(winners.getRaceWinners());
    }

    public static List<Car> setCarsOnRace() {
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

    public static void hasNextRound(List<Car> carsOnRace){
        for(Car car : carsOnRace){
            car.increasePositionOrNot(Util.getRandomNumber());
            OutputView.outputGameResult(car.toString());
        }
        System.out.println();
    }
}
