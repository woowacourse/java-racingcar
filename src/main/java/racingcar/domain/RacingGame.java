package racingcar.domain;

import java.util.List;

public class RacingGame {

    private static final String ROUND_NUMBER_ERROR = "[ERROR] 시도 횟수는 1이상이어야 합니다.";
    private static final int INITIAL_CURRENT_ROUND = 0;
    private static final int ROUND_MIN_NUM = 1;

    private final Cars cars;
    private  int totalRound;
    private int currentRound = INITIAL_CURRENT_ROUND;

    public RacingGame(final Cars cars, int totalRound){
        validateRound(totalRound);
        this.cars = cars;
        this.totalRound = totalRound;
    }

    public List<Car> playOneRound(){
        currentRound++;
        return cars.moveEachCar();
    }

    public boolean isGameEnded(){
        return totalRound <= currentRound;
    }

    public List<Car> findWinnerCars(){
        return cars.findAllWinner();
    }

    private void validateRound(int totalRound) {
        if (totalRound < ROUND_MIN_NUM) {
            throw new IllegalArgumentException(ROUND_NUMBER_ERROR);
        }
    }
}
