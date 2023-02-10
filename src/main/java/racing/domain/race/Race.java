package racing.domain.race;

import racing.domain.RandomNumberPicker;
import racing.domain.WinnerJudgeImpl;
import racing.domain.car.Car;
import racing.domain.car.CarDto;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<CarDto> getWinners() {
        return winnerJudge.getWinner(cars).stream()
                .map(CarDto::of).collect(Collectors.toList());
    }

    public List<CarDto> getCarDTOs() {
        return cars.stream().map(CarDto::of).collect(Collectors.toList());
    }
}
