package racing.domain;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void updateCarsState() {
        for (Car car : cars) {
            car.execute();
        }
    }

    public int compareStep() {
        int maxStep = Integer.MIN_VALUE;
        for (Car car : cars) {
            maxStep = compareStep(car, maxStep);
        }
        return maxStep;
    }

    private int compareStep(Car car, int maxStep) {
        return Math.max(car.getStep(), maxStep);
    }
}
