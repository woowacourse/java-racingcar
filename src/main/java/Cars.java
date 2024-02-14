import java.util.List;

public class Cars {
    List<Car> cars;

    public Cars(List<String> names) {
        this.cars = names.stream()
                .map(name -> new Car(name))
                .toList();
    }
}
