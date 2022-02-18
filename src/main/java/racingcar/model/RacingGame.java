package racingcar.model;

import racingcar.util.RandomNumberGenerator;

public class RacingGame {
    private Cars cars;
    private TrialNum trialNum;
    private int count;

    private RacingGame() {
    }

    public static RacingGame createRacingGame(String carNames, String inputTrialNum) {
        RacingGame racingGame = new RacingGame();
        racingGame.cars = Cars.initCars(carNames);
        racingGame.trialNum = TrialNum.initTrialNum(inputTrialNum);
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

    public String findWinner() {
        Winners winners = new Winners(cars);
        return winners.findName();
    }

    public boolean isEnd() {
        return trialNum.getTrialNum() == count;
    }

    public Cars getCars() {
        return cars;
    }
}
