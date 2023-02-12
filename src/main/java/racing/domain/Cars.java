package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static racing.view.output.OutputView.*;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    // 테스트를 위한 메서드
    public Car getCar(int n) {
        return cars.get(n);
    }

    public void updateCarsState() {
        for (Car car : cars) {
            execute(car);
        }
    }

    private void execute(Car car) {
        if (decideMove(getRandomNumber())) {
            moving(car);
        }
    }

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    private boolean decideMove(int randomNumber) {
        return 4 <= randomNumber;
    }

    private void moving(Car car) {
        car.increaseStep();
    }

    public void printCarsState() {
        for (Car car : cars) {
            printCarState(car);
        }
    }

    public int compareStep() {
        int maxStep = Integer.MIN_VALUE;
        for (Car car : cars) {
            maxStep = compareStep(car, maxStep);
        }
        return maxStep;
    }

    private static int compareStep(Car car, int maxStep) {
        return Math.max(car.getStep(), maxStep);
    }

    public List<String> findWinner(int winnerStep) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            findWinner(winners, car, winnerStep);
        }
        return winners;
    }

    private static void findWinner(List<String> winners, Car car, int winnerStep) {
        if (car.getStep() == winnerStep) {
            winners.add(car.getName());
        }
    }
}
