package racing.controller;

import racing.dto.MovedCar;
import racing.model.Car;
import racing.model.GameResult;
import racing.model.Random;
import racing.view.InputView;
import racing.view.OutputView;

import java.util.List;

public class Game {
    static final int RANDOM_RANGE_START = 0;
    static final int RANDOM_RANGO_END = 9;

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        List<Car> cars = InputView.getCars();
        int roundNum = InputView.getRoundNumber();
        doRounds(cars, roundNum);

        GameResult gameResult = new GameResult();
        OutputView.showChampion(gameResult.calculateChampions(cars));
    }

    static void doRounds(List<Car> cars, int roundNum) {
        OutputView.printStartTheGame();
        for (int i = 0; i < roundNum; i++) {
            doRound(cars);
        }
    }

    private static void doRound(List<Car> cars) {
        for (Car car : cars) {
            car.move(Random.getIntegerValue(RANDOM_RANGE_START, RANDOM_RANGO_END));
        }
        OutputView.showCarsPosition(cars);
    }


}
