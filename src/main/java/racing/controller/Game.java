package racing.controller;

import racing.model.Car;
import racing.model.GameResult;
import racing.view.InputView;
import racing.view.OutputView;

import java.util.List;

public class Game {
    public static void main(String[] args) {
        start();
    }


    public static void start() {
        List<Car> cars = InputView.getCars();
        List<Car> champions;
        int roundNum = InputView.getRoundNumber();

        doRounds(cars, roundNum);
        champions = GameResult.calculateChampions(cars);
        OutputView.showChampion(champions);
    }

    static void doRounds(List<Car> cars, int roundNum) {
        System.out.print("\n실행 결과");
        for (int i = 0; i < roundNum; i++) {
            doRound(cars);
        }
    }

    private static void doRound(List<Car> cars) {
        for (Car car : cars) {
            car.move(getRandomValue());
        }
        OutputView.showCarsPosition(cars);
    }

    private static int getRandomValue() {

        return (int) (Math.random() * 10);
    }

}
