package racing.domain.race;

import java.util.List;
import racing.domain.WinnerJudgeImpl;
import racing.domain.car.Car;

public class Race {
    private final RacingCars racingCars = new RacingCars();
    private WinnerJudge winnerJudge;

    private Race() {
        winnerJudge = new WinnerJudgeImpl();
    }

    public Race(List<String> carNames) {
        this();
        for (String carName : carNames) {
            Car newCar = new Car(carName);
            racingCars.add(newCar);
        }
    }

    public Race(List<String> carNames, WinnerJudge winnerJudge) {
        this(carNames);
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
