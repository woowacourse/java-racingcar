package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.Output;
import java.util.Arrays;
import java.util.stream.Collectors;

public class GameService {
    private static Cars cars;
    private static int tryNum;

    public static void setUpRace() {
        makeCarsFromInput();
        setTryNumFromInput();
    }
    
    public static void raceStart() {
        Output.printStartRace();
        for (int i = 0; i < tryNum; i++) {
            cars.moveAllByRandom();
            cars.showCarsStatus();
        }
    }

    private static void makeCarsFromInput() {
        String[] carNames = InputService.getCarNames();
        cars = new Cars(Arrays.stream(carNames)
                .map(carName -> new Car(carName))
                .collect(Collectors.toList()));
    }

    private static void setTryNumFromInput() {
        tryNum = InputService.getTryNum();
    }
}
