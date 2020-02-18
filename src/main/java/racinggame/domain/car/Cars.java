package racinggame.domain.car;

import racinggame.domain.car.movable.MovAbleStrategy;
import racinggame.domain.data.GameStatus;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();
    private MovAbleStrategy movAbleStrategy;

    public Cars(MovAbleStrategy movAbleStrategy) {
        this.movAbleStrategy = movAbleStrategy;
    }
    public void add(Car car){
        cars.add(car);
    }

    public void moveCars(GameStatus gameStatus){
        for (Car car : cars) {
            if(movAbleStrategy.isMovable()){
                car.accelerate();
            }
            car.passingLog(gameStatus);
        }
    }
}
