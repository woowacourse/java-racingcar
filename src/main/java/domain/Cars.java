package domain;

import dto.CarNameRequest;
import java.util.ArrayList;
import java.util.List;

public class Cars {
    public static final int MIN_CAR_COUNT = 2;
    public static final int MAX_CAR_COUNT = 50;
    private final List<Car> cars;


    public Cars(List<Car> cars) {
        validate(cars);
        this.cars = cars;
    }

    public static Cars from(List<Car> cars) {
        return new Cars(cars);
    }

    private void validate(List<Car> cars) {
        if (!(cars.size() >= MIN_CAR_COUNT && cars.size() <= MAX_CAR_COUNT)) {
            throw new IllegalArgumentException("경주할 수 있는 자동차는 2대에서 50대 사이입니다");
        }
    }

    public static Cars fromEmpty() {
        return new Cars(List.of(Car.fromEmpty(), Car.fromEmpty()));
    }

    public static Cars fromDto(CarNameRequest carsNameRequest) {
        List<Car> carsTmp = new ArrayList<>();
        for (String carName : carsNameRequest.list()) {
            carsTmp.add(Car.fromName(carName));
        }
        return new Cars(carsTmp);
    }

    public void move(RandomMovementGenerator randomMovementGenerator) {
        for (Car car : cars) {
            moveCar(randomMovementGenerator, car);
        }
    }

    private void moveCar(RandomMovementGenerator randomMovementGenerator, Car car) {
        if (randomMovementGenerator.generate()) {
            car.move();
        }
    }

    public Winners getWinners() {
        Car maxDistanceCar = cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("최댓값 계산에 오류가 발생했습니다."));
        List<Car> maxDistanceCars = getMaxDistanceCars(maxDistanceCar);
        return new Winners(maxDistanceCars);
    }

    private List<Car> getMaxDistanceCars(Car maxDistanceCar) {
        List<Car> maxDistanceCars = new ArrayList<>();
        cars.stream().filter(car -> car.isSameDistance(maxDistanceCar))
                .forEach(maxDistanceCars::add);
        return maxDistanceCars;
    }

    public List<Car> getCars() {
        return cars;
    }

}