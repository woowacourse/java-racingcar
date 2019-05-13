package racing.domain;

import racing.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Race {
    private List<Car> cars;

    /*
     * 경기 준비
     */
    public Race(List<String> carNames) {
        cars = new ArrayList<>();

        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    /*
     * 경기 진행 메소드
     */
    public void progressRace() {
        for (Car c : cars) {
            c.tryGoForward(RandomNumberGenerator.generate(Car.RANDOM_NUM_UPPER_BOUND));
        }
    }

    /*
     * 우승자 판별 메소드
     */
    public static List<Car> judgeWinners(List<Car> cars) {
        List<Car> winners = new ArrayList<>(cars);
        Car winner = findWinner(cars);
        winners.removeIf((c) -> (!isSamePosition(c, winner)));
        return winners;
    }

    private static Car findWinner(List<Car> cars) {
        return Collections.max(cars);
    }

    private static boolean isSamePosition(Car c1, Car c2) {
        return c1.compareTo(c2) == 0;
    }

    /*
     * 경기 결과 메소드
     */
    public List<Car> getResult() {
        return judgeWinners(cars);
    }
}
