package racing;

import racing.domain.Car;
import racing.domain.RacingCars;

import java.util.ArrayList;
import java.util.List;

import static racing.view.InputView.inputCarNames;

public class RacingGame {
    public void run(){
        String[] carNames = getCarNames();
        List<Car> carList = new ArrayList<>();

        for (String carName : carNames){
            carList.add(new Car(carName));
        }

        RacingCars racingCars = new RacingCars(carList);

    }

    private String[] getCarNames() {
        return inputCarNames().split(",");
    }
}
