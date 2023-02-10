package racing.service;

import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.NumberGenerator;
import racing.dto.GameResultDto;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameService {

    private static final int MOVE_CONDITION = 4;

    private final NumberGenerator numberGenerator;
    private final Cars cars;
    private int tryCount;

    public RacingGameService(NumberGenerator numberGenerator, int tryCount, List<Car> cars) {
        validateTryCount(tryCount);
        this.tryCount = tryCount;
        this.numberGenerator = numberGenerator;
        this.cars = new Cars(cars);
    }

    private void validateTryCount(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이여야 합니다.\n" + "시도 횟수 : " + tryCount);
        }
    }

    public GameResultDto play() {
        GameResultDto result = new GameResultDto();
        for (Car car : cars.getCars()) {
            int power = numberGenerator.generate();
            car.move(power);
            result.put(car.getName(), car.getPosition());
        }
        tryCount--;
        return result;
    }

    public boolean isEnd() {
        return tryCount == 0;
    }

    public List<String> getWinners() {
        return cars.getFirstPosition().stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
