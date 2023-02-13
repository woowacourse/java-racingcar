package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class RacingcarService {

    public Cars makeCars(String[] cars) {
        return new Cars(Arrays.stream(cars)
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public void move(Cars cars) {
        cars.move();
    }

    public List<Car> findWinner(Cars cars) {
        int winnerPosition = cars.findMaxPosition();

        return cars.findWinners(winnerPosition);
    }
}
