package car.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private static final int INITIAL_MAX_POSITION = 0;
    private final List<Car> cars;
    private final MoveChance moveChance;

    public Game(List<Car> cars, MoveChance moveChance) {
        this.cars = new ArrayList<>(cars);
        this.moveChance = moveChance;
    }
    public int findMaxPosition() {
        int maxPosition = INITIAL_MAX_POSITION;
        for (Car car : cars) {
            maxPosition = car.selectMaxPosition(maxPosition);
        }
        return maxPosition;
    }
    public void playOnce() {
        for (Car car : cars) {
            car.move(moveChance);
        }
    }
    public List<CarDto> getCarsDto(){
        List<CarDto> carDtoList = new ArrayList<>();
        for(Car car: cars){
            carDtoList.add(new CarDto(car));
        }
        return carDtoList;
    }
}
