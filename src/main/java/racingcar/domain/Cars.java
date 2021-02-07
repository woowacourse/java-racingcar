package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> carList;
    private RuleStrategy rule;
    private int maxPosition = 0;

    public Cars(String[] names, RuleStrategy strategy) {
        carList = new ArrayList<>();
        this.carList.addAll(Arrays.stream(names)
                .map(name -> new Car(name))
                .collect(Collectors.toList()));
        rule = strategy;
    }

    public List<String> getCarNames() {
        return carList.stream()
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }

    public void startRace() {
        for (Car car : carList) {
            car.move(rule.execute());
            maxPosition = car.aboveMaxPosition(maxPosition);
        }
    }
}