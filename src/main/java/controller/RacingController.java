package controller;

import domain.Car;
import domain.Cars;
import domain.Const;
import domain.Race;
import util.Util;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingController {

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

    public static void printWinners(Race race) {
        OutputView.outputWinners(race.getRaceWinners());
    }

    public static Race moveAllCar(List<Car> carList, int roundCount) {
        Race race = new Race(carList);
        OutputView.outputGameResultTile();
        for (int i = 0; i < roundCount; i++) {
            race.moveAllCarOneTime();
            OutputView.outputGameResult(race.getRaceCars());
        }
        return race;
    }
}
