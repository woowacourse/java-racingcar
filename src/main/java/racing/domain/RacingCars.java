package racing.domain;

import java.util.List;

public class RacingCars {
    private final List<Car> carList;

    public RacingCars(List<Car> carList) {
        this.carList = carList;
    }

    public void race() {
        for (Car car : carList) {
            car.move();
        }
    }

    public RaceStatusDto getRaceStatus() {
        return new RaceStatusDto(carList);
    }

}
