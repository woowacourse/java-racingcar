package racing.domain;

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

    private static int compareStep(Car car, int maxStep){
        return Math.max(car.getStep(), maxStep);
    }

    public void addWinner(int winnerStep, StringBuilder sb) {
        for (Car car : cars) {
            addWinner(car, winnerStep, sb);
        }
    }

    private static void addWinner(Car car, int winnerStep, StringBuilder sb) {
        if(car.getStep() == winnerStep){
            sb.append(car.getName()).append(COMMA);
        }
    }
}
