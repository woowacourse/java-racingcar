package racing.domain;

import java.util.List;
import java.util.stream.Collectors;
import racing.NumberGenerator;
import racing.RandomNumberGenerator;
import racing.dto.GameResultDto;

public class RacingGame {
    private static final int MOVE_CONDITION = 4;

    private final NumberGenerator numberGenerator;
    private final Cars cars;
    private int tryCount;

    public RacingGame(NumberGenerator numberGenerator, int tryCount, List<Car> cars) {
        this.numberGenerator = numberGenerator;
        this.cars = new Cars(cars);
        this.tryCount = tryCount;
    }

    public RacingGame(int tryCount, List<Car> cars) {
        this(new RandomNumberGenerator(), tryCount, cars);
    }

    public GameResultDto play() {
        GameResultDto result = new GameResultDto();
        for (Car car : cars.getCars()) {
            int number = numberGenerator.generate();
            move(car, number);
            result.put(car.getName(), car.getPosition());
        }
        tryCount--;
        return result;
    }

    private void move(Car car, int number) {
        if (number >= MOVE_CONDITION) {
            car.addPosition();
        }
    }

    public boolean isEnd() {
        return tryCount == 0;
    }

    public List<String> getWinners() {
        return cars.getFirstCars().stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
