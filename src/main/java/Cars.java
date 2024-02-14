import java.util.List;

public class Cars {
    List<Car> cars;

    public static Cars fromEmpty() {
        return new Cars();
    }

    public void move() {
        cars.forEach(Car::move);
    }
}
