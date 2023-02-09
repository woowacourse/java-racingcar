import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRepository implements CarRepositoryInterface {

    private final List<Car> carInformation = new ArrayList<>();

    @Override
    public void saveCar(Car car) {
        carInformation.add(car);
    }

    @Override
    public int findPositionByName(String name) {
        return carInformation.stream()
                .filter(car -> name.equals(car.getName()))
                .map(Car::getPosition)
                .findAny()
                .orElseThrow();
    }

    @Override
    public List<String> findNameByPosition(int position) {
        return carInformation.stream()
                .filter(car -> car.getPosition() == position)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    @Override
    public int countOfCars() {
        return carInformation.size();
    }
}
