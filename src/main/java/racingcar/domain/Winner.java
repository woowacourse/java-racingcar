package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private final List<String> winners = new ArrayList<>();

    public List<String> getWinners(List<Car> racingCars) {
        int max = getWinnerPosition(racingCars);

        racingCars.stream().filter(car -> car.isWinner(max)).forEach(car -> winners.add(car.getName()));

        return winners;
    }

    private int getWinnerPosition(List<Car> racingCars) {
        if (racingCars.stream().mapToInt(Car::getPosition).max().isPresent()) {
            return racingCars.stream().mapToInt(Car::getPosition).max().getAsInt();
        }
        throw new NullPointerException("position 이 제대로 할당되지 않았습니다.");
    }

}
