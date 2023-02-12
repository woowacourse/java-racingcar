package racingcar.domain;

import java.util.LinkedList;
import java.util.List;
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

    public Cars(List<Car> cars, boolean isTest) { // TODO : 인자 없애는 법 고민
        this.cars = cars;
    }

    public void requestMoveEachCar() {
        cars.forEach(Car::tryMove);
    }

    public List<CarDto> getStatuses() {
        List<CarDto> carDtos = new LinkedList<>();
        cars.forEach(car -> carDtos.add(car.getStatus()));
        return carDtos;
    }
    
    public List<CarDto> getWinner() {
        List<CarDto> carStatuses = this.getStatuses();
        int winnerCount = 0;
        List<CarDto> winnerStatuses = new LinkedList<>();
        for (CarDto carStatus : carStatuses) {
            winnerCount = getMaxMovedCount(winnerCount, carStatus.getMovedCount());
        }
        for (CarDto carStatus : carStatuses) {
            appendIfHaveSameMovedCount(winnerStatuses, carStatus, winnerCount);
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
