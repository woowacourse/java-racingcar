package racing.domain;

import racing.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Race {
    private List<Car> cars;

    /*
     * 경기 준비 메소드
     */
    public Race(List<String> carNames) {
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
            car.tryGoForward(RandomNumberGenerator.generate(Car.RANDOM_NUM_UPPER_BOUND));
        }
    }

    /*
     * 우승자 판별 메소드
     */
    public List<Car> judgeWinners(List<Car> cars) {
        List<Car> winners = new ArrayList<>(cars);
        Car winner = findWinner(cars);
        winners.removeIf((c) -> (!isSamePosition(c, winner)));
        return winners;
    }

    private Car findWinner(List<Car> cars) {
        return Collections.max(cars);
    }

    private boolean isSamePosition(Car c1, Car c2) {
        return c1.compareTo(c2) == 0;
    }

    /*
     * 경기 결과 메소드
     */
    public RaceResult getResult() {
        return new RaceResult(judgeWinners(cars));
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
