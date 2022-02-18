package racingcar.model;

import racingcar.model.vo.TrialNum;

import java.util.Comparator;
import java.util.stream.Collectors;


// 역할: 게임의 진행??? 게임을 초기화해서 진행하고, 우승자를 찾아주는 역할?
public class RacingGame {
    public static final int MINIMUM_POSITION = 0;
    public static final String JOIN_BY_COMMA = ", ";

    private Cars cars;
    private TrialNum trialNum;
    private int count;

    public RacingGame() {
    }

    //TODO 생성자를 이렇게 사용해도 될까 고민해보기
    public RacingGame(String carNames, String inputTrialNum) {
        this.cars = Cars.initCars(carNames);
        this.trialNum = TrialNum.initTrialNum(inputTrialNum);
        this.count = 0;
    }

    public void race() {
        cars.race();
    }

    public String findWinner() {
        int maxPosition = findMaxPosition();
        return findWinnerName(maxPosition);
    }

    private int findMaxPosition() {
        return cars.getCars().stream()
                .map(Car::getPosition)
                .max(Comparator.comparing(x -> x))
                .orElse(MINIMUM_POSITION);
    }

    private String findWinnerName(int maxPosition) {
        return cars.getCars().stream()
                .filter(car -> maxPosition == car.getPosition())
                .map(Car::getName)
                .collect(Collectors.joining(JOIN_BY_COMMA));
    }

    public boolean isEnd() {
        return trialNum.getTrialNum() == count;
    }

    public Cars getCars() {
        return cars;
    }
}
