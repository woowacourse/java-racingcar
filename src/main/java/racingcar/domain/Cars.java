package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final List<Car> carList = new ArrayList<>();

    public Cars(List<String> carNameList) {
        carNameList.stream()
        .map(carName -> carList.add(new Car(carName)));
    }
}
