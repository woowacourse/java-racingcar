package domain;

import java.util.*;

public class RacingGame {

    private final List<Car> cars;
    private final RandomNumberGenerator randomNumberGenerator;

    public RacingGame(String[] names) {
        this.cars = new ArrayList<>();

        //TODO: 메소드 분리
        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }

        this.randomNumberGenerator = new RandomNumberGenerator();
    }

    //TODO: 테스트
    public void racing() {
        for (Car car : cars) {
            car.move(randomNumberGenerator);
        }
    }

    public RacingResult getRacingResult(){
        Map<String, Integer> history = new LinkedHashMap<>();
        for (Car car : cars) {
            history.put(car.getName(), car.getPosition());
        }

        return new RacingResult(history);
    }
}
