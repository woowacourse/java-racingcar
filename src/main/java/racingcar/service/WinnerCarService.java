package racingcar.service;

import racingcar.domain.Cars;
import racingcar.domain.WinnerCar;

import java.util.List;

public class WinnerCarService {

    public WinnerCar createWinnerCar(Cars cars) {
        return WinnerCar.create(cars);
    }

    public List<String> getWinnerNames(WinnerCar winnerCar) {
        return winnerCar.getName();
    }
}
