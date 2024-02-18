package domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public void moveAll(List<Integer> randomNumbers) {
        validateSize(randomNumbers);
        for (int index = 0; index < randomNumbers.size(); index++) {
            Car car = carList.get(index);
            int randomNumber = randomNumbers.get(index);
            car.move(randomNumber);
        }
    }

    private void validateSize(List<Integer> randomNumbers) {
        if (randomNumbers.size() != getCount()) {
            throw new IllegalArgumentException("[ERROR] 갯수 불일치");
        }
    }

    public int getMaxLocation() {
        return carList.stream()
                .mapToInt(Car::getCarLocation)
                .max()
                .getAsInt();
    }

    public List<Car> getCarList() {
        return Collections.unmodifiableList(carList);
    }

    public Map<String, Integer> getCurrentLocations() {
        Map<String, Integer> locations = new LinkedHashMap<>();

        carList.forEach(car -> locations.put(car.getCarName(), car.getCarLocation()));
        return locations;
    }

    public List<String> getLargestLocationCarsName() {
        return carList.stream()
            .filter(car -> car.getCarLocation() == getMaxLocation())
            .map(Car::getCarName)
            .toList();
    }

    public int getCount() {
        return carList.size();
    }
}
