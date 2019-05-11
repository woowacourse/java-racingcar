package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RaceResult {
    private List<Car> cars = new ArrayList<>();

    public void add(Car car) {
        cars.add(car);
    }

    public String carsPositionConsoleView() {
        String result = "";

        for (Car car : cars) {
            result += car + "\n";
        }
        return result + "\n";
    }

    public String winnersConsoleView() {
        List<String> winnersName = new ArrayList<>();

        for (Car car : WinningCarsFinder.findWinningCars(cars)) {
            winnersName.add(car.getName());
        }
        return String.join(", ", winnersName) + "가 최종 우승했습니다.";
    }
}
