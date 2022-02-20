package racingcar.model;

import racingcar.util.RandomNumberGenerator;

import java.util.List;

public class RacingGame {
    private Cars cars;
    private TrialNum trialNum;
    private int count;

    private RacingGame() {
    }

//    public static RacingGame createRacingGame(String carNames, String inputTrialNum) {
//        RacingGame racingGame = new RacingGame();
//        racingGame.cars = Cars.initCars(carNames);
//        racingGame.trialNum = TrialNum.initTrialNum(inputTrialNum);
//        racingGame.count = 0;
//        return racingGame;
//    }

    public static RacingGame createRacingGame(List<Car> cars, String trialNum) {
        RacingGame racingGame = new RacingGame();
        racingGame.cars = Cars.initCars(cars);
        racingGame.trialNum = TrialNum.initTrialNum(trialNum);
        racingGame.count = 0;
        return racingGame;
    }

    public void race() {
        RandomNumberGenerator numberGenerator = new RandomNumberGenerator();
        cars.race(numberGenerator);
        increaseTrialCount();
    }

    private void increaseTrialCount() {
        count++;
    }

    public Winners findWinner() {
        Cars winnerCars = cars.findWinnerCars();
        return new Winners(winnerCars);
    }

    public boolean isEnd() {
        return trialNum.isTrialNumEqualCount(count);
    }

    public Cars getCars() {
        return cars;
    }
}
