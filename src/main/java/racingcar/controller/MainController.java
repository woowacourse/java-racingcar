package racingcar.controller;

import racingcar.domain.Car;
import java.util.List;
import racingcar.service.CarService;
import racingcar.service.InputService;

public class MainController {
    private List<Car> cars;
    private int tryNum;

    public MainController() {
    }

    public void play() {
        cars = InputService.inputCars();
        tryNum = InputService.inputTryNum();

        CarService.startRace(cars, tryNum);
        CarService.finalWinner(cars);
    }
}
