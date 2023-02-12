package racing.domain.race;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racing.domain.RandomNumberPicker;
import racing.domain.WinnerJudgeImpl;
import racing.domain.car.Car;

public class Race {
    private final List<Car> cars = new ArrayList<>();
    private final NumberPicker numberPicker;
    private WinnerJudge winnerJudge;

    public Race() {
        numberPicker = new RandomNumberPicker();
        winnerJudge = new WinnerJudgeImpl();
    }

    public Race(List<String> carNames) {
        this();
        for (String carName : carNames) {
            addNewCarBy(carName);
        }
    }

    public Race(List<String> carNames, WinnerJudge winnerJudge) {
        this(carNames);
        this.winnerJudge = winnerJudge;
    }

    private void addNewCarBy(String carName) {
        Car car = new Car(carName);
        if (carWithSameNameAlreadyExists(car)) {
            throw new IllegalArgumentException("자동차 이름은 중복일 수 없습니다.");
        }
        cars.add(car);
    }

    private boolean carWithSameNameAlreadyExists(Car car) {
        return cars.contains(car);
    }

    public void tryMoveOneTime() {
        for (Car car : cars) {
            car.moveDependingOn(numberPicker.pickNumber());
        }
    }

    public List<Car> getWinners() {
        return winnerJudge.getWinner(cars);
    }

    public List<Car> getParticipatingCars() {
        return Collections.unmodifiableList(cars);
    }
}
