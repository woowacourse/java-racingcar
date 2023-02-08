import java.util.ArrayList;
import java.util.List;

public class Winner {
    List<String> winnerNames;

    public Winner() {
        this.winnerNames = new ArrayList<>();
    }

    private int findMaxDistance(List<Car> cars) {
        int maxDistance = 0;
        for (Car car : cars) {
            int distance = car.getDistance();
            if (distance > maxDistance) {
                maxDistance = distance;
            }
        }
        return maxDistance;
    }

    public void findWinnerNames(List<Car> cars) {
        int maxDistance = findMaxDistance(cars);
        for (Car car : cars) {
            if (car.getDistance() == maxDistance) {
                winnerNames.add(car.getName());
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s가 최종 우승했습니다.", String.join(", ", winnerNames));
    }
}
