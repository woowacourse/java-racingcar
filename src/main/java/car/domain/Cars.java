package car.domain;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class Cars {
    
    private static final String NAME_DELIMITER = ",";
    
    private final List<Car> racingCars;
    
    Cars(List<Car> racingCars) {
        this.racingCars = racingCars;
    }
    
    public static Cars from(String carNames) {
        return Cars.of(carNames, carName -> new Car.Builder(carName).build());
    }
    
    static Cars fromCarNamesWithFakeEngine(String carNames, int moveCondition) {
        final Function<String, Car> nameToCarFunction = name -> new Car.Builder(name).withFakeEngine(moveCondition)
                                                                                     .build();
        
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
    
    public Cars race() {
        for (int i = 0, size = racingCars.size(); i < size; i++) {
            final Car car = racingCars.get(i);
            racingCars.set(i, car.move());
        }
        
        return new Cars(racingCars);
    }
    
    public ScoreBoard recordScore() {
        return ScoreBoard.record(racingCars);
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
