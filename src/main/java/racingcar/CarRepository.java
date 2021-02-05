package racingcar;

import racingcar.utils.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {
    private static final int START = 0;
    private static final int END = 9;

    private static final List<Car> cars = new ArrayList<>();

    private CarRepository(){
    }

    public static void addCars(List<String> splittedCarNames){
        CarNameRepository.addCarNames(splittedCarNames);
        CarNameRepository.getCarNames().stream().map(carName -> cars.add(new Car(carName)));
    }

    public static void raceOneLap() {
        cars.forEach(car -> car.moveForwardByRandomNumber(RandomUtil.nextInt(START, END)));
    }
}
