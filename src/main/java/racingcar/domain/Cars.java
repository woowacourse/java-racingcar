package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    public static final String DELIMITER = ",";
    private List<Car> cars;

    public Cars(String inputNames) {
        cars = Arrays.stream(inputNames.split(DELIMITER))
                .map(x -> new Car(x))
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        int maximum = 0;

        for (Car car : cars) {
            if(maximum < car.getPosition()){
                winners.clear();
                maximum = car.getPosition();
                winners.add(car.getName());
            } else if (maximum == car.getPosition()){
                winners.add(car.getName());
            }
        }

        return winners;
    }
}
