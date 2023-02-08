package controller;

import domain.Car;
import domain.MovingCount;
import view.InputView;

import java.util.List;

public class RacingController {
    private List<Car> carInfo;
    private MovingCount movingCount;
    private final InputView inputView = new InputView();

    public void setUp() {
        for (String carName : inputView.readCarNames()) {
            carInfo.add(new Car(carName));
        }
        movingCount = new MovingCount(inputView.readMovingCount());
    }
}
