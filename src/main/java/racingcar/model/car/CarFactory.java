package racingcar.model.car;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.car.strategy.MovingStrategy;
import racingcar.view.dto.CarNamesRequest;

public class CarFactory {
    private final MovingStrategy movingStrategy;

    public CarFactory(MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
    }

    public Cars generateCarsFromCarNames(CarNamesRequest carNamesRequest) {
        List<Car> carsByNames = carNamesRequest.toSplitCarNames().stream()
                .map(carName -> new Car(carName, movingStrategy))
                .collect(Collectors.toList());

        return new Cars(carsByNames);
    }
}
