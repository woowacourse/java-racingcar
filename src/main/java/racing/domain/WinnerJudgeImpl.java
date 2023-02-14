package racing.domain;

import java.util.List;
import java.util.stream.Collectors;
import racing.domain.car.Car;
import racing.domain.race.WinnerJudge;

public class WinnerJudgeImpl implements WinnerJudge {
    @Override
    public List<Car> getWinner(List<Car> cars) {
        int winPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition() == winPosition)
                .collect(Collectors.toList());
    }
}
