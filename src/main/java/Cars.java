import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Cars {
    List<Car> cars;

    public Cars(List<String> names) {
        this.cars = names.stream()
                .map(name -> new Car(name))
                .toList();
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
}
