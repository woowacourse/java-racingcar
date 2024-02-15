import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Cars {
    List<Car> cars;

    public Cars(List<String> names, NumberGenerator numberGenerator) {
        if (names.size() == 0) {
            throw new IllegalArgumentException();
        }
        if (names.stream().distinct().count() != names.size()) {
            throw new IllegalArgumentException();
        }
        this.cars = names.stream()
                .map(name -> new Car(name, numberGenerator))
                .toList();
    }

    public void tryMove(){
        for (Car car : cars) {
            car.tryMove();
        }
    }

    public List<String> getWinnersName() {
        List<String> winnersName = new ArrayList<>();
        int maxLocation = getMaxLocation();
        for (Car car : cars) {
            if (car.getLocation() == maxLocation) {
                winnersName.add(car.getName());
            }
        }
        return winnersName;
    }

    private int getMaxLocation() {
        int maxLocation = 0;
        for (Car car : cars) {
            maxLocation = Math.max(maxLocation, car.getLocation());
        }
        return maxLocation;
    }

    public List<Car> getRoundResult() {
        return cars;
    }
}
