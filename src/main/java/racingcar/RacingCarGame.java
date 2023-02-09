package racingcar;

import java.util.List;

import static constant.Constants.TRIAL_INPUT_EXCEPTION;

public class RacingCarGame {

    public void repeatRounds() {
        List<Car> cars = CarRepository.findAll();
        for (Car car : cars) {
            car.move(new RandomBasedStrategy());
        }
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        return CarRepository.findSamePositionWith(maxPosition);
    }

    private int getMaxPosition() {
        return CarRepository.findAll().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
