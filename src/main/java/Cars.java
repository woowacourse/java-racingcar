import java.util.List;

public class Cars {
    List<Car> cars;

    public Cars(List<String> names) {
        this.cars = names.stream()
                .map(name -> new Car(name))
                .toList();
    }

    private int getMaxLocation() {
        int maxLocation = 0;
        for (Car car : cars) {
            maxLocation = Math.max(maxLocation, car.getLocation());
        }
        return maxLocation;
    }
}
