package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Referee {

    private int maxPosition = 0;
    private List<String> winners = new ArrayList<>();
    
    public List<String> generateWinners(List<Car> carList){
        
        for(Car car : carList){
            maxPosition = car.comparePosition(maxPosition);
        }

        for(Car car : carList){
            addWinners(car);
        }
        return winners;
    }

    private void addWinners(Car car) {
        if(car.checkIsWinner(maxPosition)){
            winners.add(car.getName());
        }
    }

}
