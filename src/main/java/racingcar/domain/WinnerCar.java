package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerCar {

    private final Cars carInfo;

    private WinnerCar(final Cars carInfo) {
        this.carInfo = carInfo;
    }

    public static WinnerCar create(Cars carInfo) {
        return new WinnerCar(carInfo);
    }

    public List<String> getName() {
        Car maxPositionCar = carInfo.getMaxPositionCar();
        return getWinnerNames(maxPositionCar);
    }

    private List<String> getWinnerNames(Car maxPositionCar) {
        return carInfo.getCars()
                .stream()
                .filter(maxPositionCar::isSamePosition)
                .map(Car::getName)
                .collect(Collectors.toUnmodifiableList());
    }
}
