package racing.domain;

import java.util.List;

public class RaceStatusDto {
    private final List<Car> carList;

    public RaceStatusDto(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> getCarList(){
        return carList;
    }
}
