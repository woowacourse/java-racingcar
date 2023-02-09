package racingcar;

import java.util.List;

public class RacingCarGame {

    private static final int START_POSITION = 0;

    public void repeatRounds() {
        for (Car car : CarRepository.findAll()) {
            car.move(new RandomBasedStrategy());
        }
    }

    public List<String> getWinners() {
        return CarRepository.findSamePositionWith(getMaxPosition());
    }

    private int getMaxPosition() {
        return CarRepository.findAll().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(START_POSITION);
    }
}
