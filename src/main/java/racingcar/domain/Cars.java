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
        List<CarDto> carDtos = cars.stream()
                .map(CarDto::new)
                .collect(Collectors.toList());
        int winnerCount = 0;
        List<CarDto> winnerStatuses = new LinkedList<>();
        for (CarDto carDto : carDtos) {
            winnerCount = getMaxMovedCount(winnerCount, carDto.getMovedCount());
        }
        for (CarDto carDto : carDtos) {
            appendIfHaveSameMovedCount(winnerStatuses, carDto, winnerCount);
        }
        return winnerStatuses;
    }
    
    private int getMaxMovedCount(int winnerCount, int movedCount) {
        return Math.max(winnerCount, movedCount);
    }
    
    private void appendIfHaveSameMovedCount(List<CarDto> winners, CarDto carDto, int winnerCount) {
        if (carDto.getMovedCount() == winnerCount) {
            winners.add(carDto);
        }
    }

    public boolean isEmpty() {
        return this.cars.isEmpty();
    }

}
