package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> carList;

    public Cars(String[] names) {
        carList = new ArrayList<>();
        this.carList.addAll(Arrays.stream(names)
                .map(name -> new Car(name))
                .collect(Collectors.toList()));
    }

    public List<String> getCarNames() {
        return carList.stream()
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }
}
