package racingcar.domain;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import racingcar.view.log.CarForLog;
import racingcar.domain.random.RandomNumberGenerator;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> names) {
        cars = names.stream()
                .map(Car::new)
                .collect(toList());
    }

    public void move(RandomNumberGenerator randomNumberGenerator) {
        for (Car car : cars) {
            moveOneCar(randomNumberGenerator, car);
        }
    }

    private void moveOneCar(RandomNumberGenerator randomNumberGenerator, Car car) {
        if (randomNumberGenerator.isMoveAvailable()) {
            car.forwardCarPosition();
        }
    }

    public List<CarForLog> generateCarForLogList() {
        List<CarForLog> carForLogList = new ArrayList<>();
        for (Car car : cars) {
            carForLogList.add(new CarForLog(car.getName(), car.getPosition()));
        }
        return carForLogList;
    }
}
