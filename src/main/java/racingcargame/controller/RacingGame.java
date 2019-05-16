package racingcargame.controller;

import racingcargame.model.Car;
import racingcargame.model.CarsGenerator;
import racingcargame.model.TurnsGenerator;
import racingcargame.view.InputView;

import java.util.*;

public class RacingGame {
    private int totalTurns = 0;

    public void play() {
        List<Car> cars = makeCars();
        getTotalTurns();

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

    private void getTotalTurns() {
        try {
            String input = InputView.askTotalTurns();
            int totalTurns = TurnsGenerator.makeTurns(input);
            this.totalTurns = totalTurns;
        } catch(Exception e) {
            System.out.println("잘못된 입력입니다");
            getTotalTurns();
        }
    }



}
