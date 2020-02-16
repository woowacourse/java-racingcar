package racingcar.domain;

import java.util.List;

public class Cars {
    private final List<Car> racingCarList;

    public Cars(List<Car> racingCarList) {
        this.racingCarList = racingCarList;
    }

    public List<Car> getRacingCarList() {
        return racingCarList;
    }

}
