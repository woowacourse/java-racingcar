package racingcar.model;

import racingcar.model.vo.TrialNum;

public class RacingGame {
    private Cars cars;
    private TrialNum trialNum;

    public RacingGame() {
    }

    //TODO 생성자를 이렇게 사용해도 될까 고민해보기
    public RacingGame(String carNames, String inputTrialNum) {
        this.cars = Cars.initCars(carNames);
        this.trialNum = TrialNum.initTrialNum(inputTrialNum);
    }

    public void race() {
        cars.race();
    }

    public Cars getCars() {
        return cars;
    }

    public TrialNum getTrialNum() {
        return trialNum;
    }
}
