package racing.domain;

import racing.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Race {
    private List<Car> cars = new ArrayList<>();
    public Race(List<String>carNames){
        createCars(carNames);
    }

    /*
     * 경기 준비 메소드
     */
    public void createCars(List<String> carNames) {
        Iterator<String> it = carNames.iterator();
        while (it.hasNext()) {
            cars.add(new Car(it.next()));
        }
    }

    /*
     * 경기 진행 메소드
     */
    public void progressRace() {
        Iterator<Car> it = cars.iterator();
        while (it.hasNext()) {
            Car car = it.next();
            car.tryGoForward(RandomNumberGenerator.generate(Car.MAX_RANDOM_NUM_UPPER_BOUND));
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
