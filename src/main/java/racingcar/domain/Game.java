package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.constants.SystemConstants.NUMBER_ONE_FOR_INCREMENT;
import static racingcar.constants.GameConstants.INITIAL_ROUND_NUM;

public class Game {

    private final Cars cars = new Cars();
    private final int totalRounds;
    private int currentRound = INITIAL_ROUND_NUM;

    public Game(String[] carNames, int totalRounds) {
        initCars(carNames);
        this.totalRounds = totalRounds;
    }

    private void initCars(String[] carNames) {
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    public List<Car> getCars() {
        return cars.findAllCars();
    }

    public void playRound() {
        cars.race();
        addOneRound();
    }

    private void addOneRound() {
        currentRound += NUMBER_ONE_FOR_INCREMENT;
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();

        return getCars().stream()
                .filter((car) -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return getCars().stream()
                .mapToInt(Car::getPosition)
                .max().orElseThrow(null);
    }

    public boolean isOver() {
        return currentRound >= totalRounds;
    }
}
