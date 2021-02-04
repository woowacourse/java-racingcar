package racingcar.domain;

import racingcar.view.RacingCarView;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final List<Car> carList = new ArrayList<>();

    public Cars(List<String> carNameList) {
        carNameList.stream()
        .map(carName -> carList.add(new Car(carName)));
    }

    public void showCarsPosition() {
        carList.stream()
            .forEach(car -> RacingCarView.displayPosition(car));

    }
}
