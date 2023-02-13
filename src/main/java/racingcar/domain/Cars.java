package racingcar.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarDto;
import racingcar.util.IntGenerator;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = new LinkedList<>();
        carNames.forEach(carName -> cars.add(new Car(carName)));
    }

    public Cars(List<String> carNames, IntGenerator intGenerator) {
        this.cars = new LinkedList<>();
        carNames.forEach(carName -> cars.add(new Car(carName, intGenerator)));
    }

    public Cars(List<Car> cars, boolean isTest) {
        this.cars = cars;
    }

    public void requestMoveEachCar() {
        cars.forEach(Car::tryMove);
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<CarDto> getWinner() {
        int winnerCount = 0;
        List<CarDto> carDtos = cars.stream()
                .map(CarDto::new)
                .collect(Collectors.toList());
        for (CarDto carDto : carDtos) {
            winnerCount = getMaxMovedCount(winnerCount, carDto.getMovedCount());
        }
        final int finalWinnerCount = winnerCount;
        return carDtos.stream()
                .filter(carDto -> carDto.getMovedCount() == finalWinnerCount)
                .collect(Collectors.toList());
    }
    
    private int getMaxMovedCount(int winnerCount, int movedCount) {
        return Math.max(winnerCount, movedCount);
    }

    public boolean isEmpty() {
        return this.cars.isEmpty();
    }

}
