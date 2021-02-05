package car;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class Cars {
    
    private static final String NAME_DELIMITER = ",";
    
    private final List<Car> racingCars;
    
    public static Cars from(String carNames) {
        return Cars.of(carNames, Car::fromNameWithRacingEngine);
    }
    
    static Cars fromCarNamesWithFakeEngine(String carNames, int moveCondition) {
        final Function<String, Car> nameToCarFunction = carName -> Car.fromNameWithFakeEngine(carName, moveCondition);
        
        return of(carNames, nameToCarFunction);
    }
    
    private static Cars of(String carNames, Function<String, Car> nameToCarFunction) {
        final String[] racingCarNames = carNames.split(NAME_DELIMITER);
        
        final List<Car> racingCars = mapNameToCar(racingCarNames, nameToCarFunction);
        
        return new Cars(racingCars);
    }
    
    private static LinkedList<Car> mapNameToCar(String[] racingCarNames, Function<String, Car> nameToCarFunction) {
        return Arrays.stream(racingCarNames)
                     .map(nameToCarFunction)
                     .collect(Collectors.toCollection(LinkedList::new));
    }
    
    private Cars(List<Car> racingCars) {
        this.racingCars = racingCars;
    }
    
    public Cars race() {
        for (int i = 0, size = racingCars.size(); i < size; i++) {
            final Car car = racingCars.get(i);
            racingCars.set(i, car.move());
        }
        
        return new Cars(racingCars);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cars cars = (Cars) o;
        return Objects.equals(racingCars, cars.racingCars);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(racingCars);
    }
}
