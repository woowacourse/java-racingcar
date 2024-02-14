import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars fromEmpty() {
        return new Cars(new ArrayList<>());
    }

    public static Cars from(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(Car.fromName(carName));
        }
        return new Cars(cars);
    }

    public void move(RandomMovementGenerator randomMovementGenerator) {
        for (Car car : cars) {
            if (randomMovementGenerator.generate()) {
                car.move();
            }
        }
    }

    public List<Car> getMaxDistanceCars() {
        List<Car> winners = new ArrayList<>();
        int maxDistance = cars.stream()
                .map(Car::getDistance)
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("최댓값 계산에 오류가 발생했습니다."));

        for (Car car : cars) {
            if (car.isSameDistance(maxDistance)) {
                winners.add(car);
            }
        }
        return winners;
    }

    public List<Car> getCars() {
        return cars;
    }
}
