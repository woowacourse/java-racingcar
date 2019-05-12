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
     * 우승자 판별 메소드
     */
    public List<Car> judgeWinners() {
        List<Car> winners = new ArrayList<>();
        Car winner = findWinner(), curCar;
        Iterator<Car> it = cars.iterator();
        while (it.hasNext()) {
            curCar = it.next();
            if (curCar.compareTo(winner) == 0) {
                winners.add(curCar);
            }
        }
        return winners;
    }

    private Car findWinner() {
        return Collections.max(cars);
    }


    /*
     * 경기 결과 메소드
     */
    public RaceResult getResult() {
        return new RaceResult(judgeWinners());
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
