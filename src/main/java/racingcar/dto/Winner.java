package racingcar.dto;

import java.util.List;

public class Winner {
    private List<Car> carList;
    private int maxDistance;

    public Winner(List<Car> carList, int maxDistance) {
        this.carList = carList;
        this.maxDistance = maxDistance;
    }

}
