package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    private int maxDistance = 0;

    public List<String> racingResult(List<Car> carList){
        List<String> winnerList = new ArrayList<>();

        for(Car car : carList){
            maxDistance = getMaxDistance(maxDistance, car);
        }
        for(Car car : carList) {
            winnerList = checkMaxPosition(car, winnerList);
        }

        return winnerList;
    }

    public int getMaxDistance(int maxDistance, Car car){
        if(car.getPosition() > maxDistance){
            maxDistance = car.getPosition();
        }
        return maxDistance;
    }

    public List<String> checkMaxPosition(Car car, List<String> winnerList){
        if(car.getPosition() == maxDistance){
            winnerList.add(car.getName());
            return winnerList;
        }

        return winnerList;
    }
}
