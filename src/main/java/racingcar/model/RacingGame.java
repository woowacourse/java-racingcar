package racingcar.model;

import racingcar.util.RandomNumberGenerator;


// 역할: 게임의 진행??? 게임을 초기화해서 진행하고, 우승자를 찾아주는 역할?
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
