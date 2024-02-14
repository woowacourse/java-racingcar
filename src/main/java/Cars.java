import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cars {
    List<Car> cars;

    public static Cars fromEmpty() {
        return new Cars();
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
}
