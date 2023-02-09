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

    @Override
    public List<Integer> positions() {
        List<Integer> positions = new ArrayList<>();
        for (Car car : carInformation) {
            positions.add(car.getPosition());
        }
        return positions;
    }

    @Override
    public List<String> carNames() {
        List<String> carNames = new ArrayList<>();
        for (Car car : carInformation) {
            carNames.add(car.getName());
        }
        return carNames;
    }

    @Override
    public void addPosition(String carName) {
        Car findedCar = carInformation.stream()
                .filter(car -> carName.equals(car.getName()))
                .findAny()
                .orElseThrow();

        findedCar.setPosition(findedCar.getPosition() + 1);
    }
}
