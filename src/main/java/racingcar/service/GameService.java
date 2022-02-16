package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.Output;
import java.util.Arrays;
import java.util.stream.Collectors;

public class GameService {
    private Cars cars;
    private int tryNum;

    public void setUpRace() {
        makeCarsFromInput();
        setTryNumFromInput();
    }
    
    public void runRace() {
        Output.printStartRace();
        for (int i = 0; i < tryNum; i++) {
            cars.moveAllByRandom();
            cars.showCarsStatus();
        }
    }

    private void makeCarsFromInput() {
        String[] carNames = InputService.getCarNames();
        cars = new Cars(Arrays.stream(carNames)
                .map(carName -> new Car(carName))
                .collect(Collectors.toList()));
    }

    private void setTryNumFromInput() {
        tryNum = InputService.getTryNum();
    }

    public void showWinners() {
        Output.printWinner(cars.findAllWinners());
    }
}
