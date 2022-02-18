package racingcar.model;

import racingcar.util.InputValidator;

public class RacingGame {
    private Cars cars;
    private int trialNum;

    public RacingGame() {
    }

    //TODO 생성자를 이렇게 사용해도 될까 고민해보기
    public RacingGame(String carNames, String inputTrialNum) {
        this.cars = Cars.initCars(carNames);
        this.trialNum = convertToInteger(inputTrialNum);
    }

    private int convertToInteger(String number) {
        InputValidator.validateTrialInput(number);
        return Integer.parseInt(number);
    }

    public void race() {
        cars.race();
    }

    public Cars getCars() {
        return cars;
    }

    public int getTrialNum() {
        return trialNum;
    }
}
