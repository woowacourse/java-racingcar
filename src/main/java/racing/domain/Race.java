package racing.domain;

import racing.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Race {
    private List<Car> cars;
    private List<String>carNames;
    public Race(final List<String>carNames){
        this.carNames = carNames;
        this.cars = createCars();
    }

    /*
     * 경기 준비 메소드
     */
    public List<Car> createCars() {
        List<Car> carList = new ArrayList<>();
        Iterator<String> it = carNames.iterator();
        while (it.hasNext()) {
            carList.add(new Car(it.next()));
        }
        return carList;
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
