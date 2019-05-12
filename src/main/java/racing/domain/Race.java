package racing.domain;

import racing.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Race {
    private List<Car> cars;

    /*
     * 경기 준비 메소드
     */
    public void createCars(List<String> carNames) {
        cars = new ArrayList<>();
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

    /*
     * 경기 결과 메소드
     */
    public RaceResult getResult() {
        Referee referee = new Referee(cars);
        return referee.getResult();
    }

    @Override
    public String toString() {
        List<String> result = new ArrayList<>();

        Iterator<Car> it = cars.iterator();
        while (it.hasNext()) {
            result.add(it.next().toString());
        }
        return String.join("\n", result);
    }
}
