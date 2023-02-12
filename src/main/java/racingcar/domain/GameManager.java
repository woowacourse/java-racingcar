package racingcar.domain;

import racingcar.dto.CarNamesRequest;
import racingcar.dto.CarStatusResponse;
import racingcar.dto.GameResultResponse;
import racingcar.dto.GameRoundRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GameManager {
    private final NumberGenerator numberGenerator;
    private Cars cars;
    private GameRound gameRound;

    public GameManager(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void createCars(CarNamesRequest inputCarNames) {
        cars = new Cars();
        List<String> carNames = inputCarNames.getCarNames();
        cars.createCars(carNames, numberGenerator);
    }

    public void createGameRound(GameRoundRequest inputGameRound) {
        int totalRound = inputGameRound.getRound();
        gameRound = new GameRound(totalRound);
    }

    public List<CarStatusResponse> playGameRound() {
        cars.moveCars();
        gameRound.increaseRound();
        Set<Car> currentCars = cars.getCars();
        return convertCarToCarStatus(currentCars);
    }

    public boolean isEnd() {
        return gameRound.isEnd();
    }

    public GameResultResponse decideWinner() {
        return new GameResultResponse(cars.findWinnerNames());
    }

    private List<CarStatusResponse> convertCarToCarStatus(Set<Car> carsStatus) {
        List<CarStatusResponse> roundResultCarStatus = new ArrayList<>();
        for (Car car : carsStatus) {
            roundResultCarStatus.add(new CarStatusResponse(car));
        }
        return roundResultCarStatus;
    }
}
