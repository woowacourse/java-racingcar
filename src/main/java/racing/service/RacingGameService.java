package racing.service;

import java.util.List;
import racing.NumberGenerator;
import racing.domain.Car;
import racing.domain.Cars;
import racing.dto.GameResultDto;

public class RacingGameService {

    private final NumberGenerator numberGenerator;
    private final Cars cars;
    private int tryCount;

    public RacingGameService(NumberGenerator numberGenerator, int tryCount, List<Car> cars) {
        this.numberGenerator = numberGenerator;
        this.cars = new Cars(cars);
        this.tryCount = tryCount;
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
        if (number >= 4) {
            car.addPosition();
        }
    }
    
}
