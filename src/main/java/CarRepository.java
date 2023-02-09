import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRepository implements CarRepositoryInterface {

    private final List<Car> carInformation = new ArrayList<>();

    @Override
    public void saveCar(Car car) {
        carInformation.add(car);
    }
}
