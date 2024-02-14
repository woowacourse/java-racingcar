package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Referee {
    
    public List<String> generateWinners(List<Car> carList){
        
        int maxPosition = 0;
        List<String> winners = new ArrayList<>();
        for(Car car : carList){
            maxPosition = Math.max(maxPosition,car.getPosition());
        }

        for(Car car : carList){
            if(maxPosition == car.getPosition()){
                winners.add(car.getName());
            }
        }
        return winners;
    }

}
