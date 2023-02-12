package racingcar.domain;

import racingcar.dto.CarNamesRequest;
import racingcar.dto.CarStatusResponse;
import racingcar.dto.GameResultResponse;
import racingcar.dto.GameRoundRequest;

import java.util.ArrayList;
import java.util.List;

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
        for (String carName : carNames) {
            cars.addCar(new Car(carName));
        }
    }

    public void createGameRound(GameRoundRequest inputGameRound) {
        int totalRound = inputGameRound.getRound();
        gameRound = new GameRound(totalRound);
    }

    public List<CarStatusResponse> playGameRound() {
        List<Car> currentCars = cars.getCars();
        for (Car car : currentCars) {
            car.move(numberGenerator.generateNumber());
        }
        gameRound.increaseRound();
        return convertCarToCarStatus(currentCars);
    }

    public boolean isEnd() {
        return gameRound.isEnd();
    }

    public GameResultResponse decideWinner() {
        return new GameResultResponse(cars.findWinnerNames());
    }

    private List<CarStatusResponse> convertCarToCarStatus(List<Car> carsStatus) {
        List<CarStatusResponse> roundResultCarStatus = new ArrayList<>();
        for (Car car : carsStatus) {
            roundResultCarStatus.add(new CarStatusResponse(car));
        }
        return roundResultCarStatus;
    }
}
