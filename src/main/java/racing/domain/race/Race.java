package racing.domain.race;

import java.util.List;
import racing.domain.car.Car;

public class Race {
    private final RacingCars racingCars = new RacingCars();
    private WinnerJudge winnerJudge;

    public Race(List<String> carNames, WinnerJudge winnerJudge) {
        for (String carName : carNames) {
            Car newCar = new Car(carName);
            racingCars.add(newCar);
        }
        this.winnerJudge = winnerJudge;
    }

    public void tryMoveOneTime() {
        racingCars.moveCars();
    }

    public List<Car> getWinners() {
        return winnerJudge.getWinner(racingCars.getCars());
    }

    public List<Car> getRacingCars() {
        return racingCars.getCars();
    }
}
