package domain;

import dto.CarNameRequest;
import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars fromEmpty() {
        return new Cars(new ArrayList<>());
    }

    public static Cars from(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(Car.fromName(carName));
        }
        return new Cars(cars);
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

    private static void moveCar(RandomMovementGenerator randomMovementGenerator, Car car) {
        if (randomMovementGenerator.generate()) {
            car.move();
        }
    }

    public List<Car> getMaxDistanceCars() {
        List<Car> winners = new ArrayList<>();
        Car maxDistanceCar = cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("최댓값 계산에 오류가 발생했습니다."));

        for (Car car : cars) {
            addWinners(car, maxDistanceCar, winners);
        }
        return winners;
    }

    private static void addWinners(Car car, Car maxDistanceCar, List<Car> winners) {
        if (car.isSameDistance(maxDistanceCar)) {  //TODO: 메서드 분리 더 잘하기
            winners.add(car);
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}