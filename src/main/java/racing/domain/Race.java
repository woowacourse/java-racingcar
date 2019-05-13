package racing.domain;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private List<Car> cars;
    private final List<String> carNames;
    private final MovementStrategy strategy;

    public Race(final List<String> carNames) {
        this(carNames, new NumberGenerate());
    }

    public Race(final List<String> carNames, MovementStrategy strategy) {
        this.carNames = Collections.unmodifiableList(carNames);
        this.cars = this.carNames.stream().map(name -> new Car(name)).collect(Collectors.toList());
        this.strategy = strategy;
    }

    /*
     * 경기 진행 메소드
     */
    public void progressRace() {
        Iterator<Car> it = cars.iterator();
        while (it.hasNext()) {
            Car car = it.next();
            car.tryGoForward(strategy);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    /*
     * 경기 결과 메소드
     */
    public List<String> getResult() {
        RaceResult raceResult = new RaceResult(cars);
        return raceResult.getWinnerNames();
    }

}
