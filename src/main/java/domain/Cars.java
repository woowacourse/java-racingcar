package domain;

import dto.CarStatus;
import dto.TurnResult;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    public static final int MIN_CAR_COUNT = 2;
    public static final int MAX_CAR_COUNT = 50;
    private final List<Car> cars;


    public Cars(List<Car> cars) {
        validate(cars);
        this.cars = cars;
    }

    public static Cars from(List<String> cars) {
        return new Cars(cars.stream().map(Car::fromName).collect(Collectors.toList()));
    }


    private void validate(List<Car> cars) {
        if (!(cars.size() >= MIN_CAR_COUNT && cars.size() <= MAX_CAR_COUNT)) {
            throw new IllegalArgumentException("경주할 수 있는 자동차는 2대에서 50대 사이입니다");
        }
    }

    public List<TurnResult> move(RandomMovementGenerator randomMovementGenerator, Count count) {
        List<TurnResult> turnResults = new ArrayList<>();
        int counter = 1;
        while (count.isGreaterOrEqualThan(counter)) {
            cars.forEach(car -> moveCar(randomMovementGenerator, car));
            turnResults.add(new TurnResult(cars.stream()
                    .map(CarStatus::new)
                    .collect(Collectors.toList())));
            counter++;
        }
        return turnResults;
    }


    private void moveCar(RandomMovementGenerator randomMovementGenerator, Car car) {
        if (randomMovementGenerator.generate()) {
            car.move();
        }
    }

    public List<Car> getCars() {
        return cars;
    }

}
