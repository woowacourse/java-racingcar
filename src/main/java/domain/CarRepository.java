package domain;

import java.util.List;
import java.util.Map;
import strategy.MovingStrategy;

public interface CarRepository {

    void cycleCars(MovingStrategy movingStrategy);
    void move(Car car,int number);
    boolean isAllowedToMove(int number);
    List<Car> findWinners();
    Map<Car, Integer> getCarBoard();

    void insertCarBoard(Map<Car, Integer> cars);

}
