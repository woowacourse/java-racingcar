package domain;

import util.Util;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Car> raceCars;

    public Race(List<Car> raceCars) {
        this.raceCars = raceCars;
    }

    public void MoveAllCarOneTime(){
        for(Car car : raceCars){
            car.increasePositionOrNot(Util.getRandomNumber());
        }
    }

    public List<Car> getRaceCars(){
        return raceCars;
    }

    public String getRaceWinners() {
        int maxPosition = findMaxPosition();
        List<String> winnersList = new ArrayList<>();
        for(Car car : raceCars){
            if(car.getPosition() == maxPosition){
                winnersList.add(car.getName());
            }
        }
        return String.join(",",winnersList);
    }

    private int findMaxPosition() {
        int max = 0;
        for(Car car : raceCars){
            if(max < car.getPosition()){
                max = car.getPosition();
            }
        }
        return max;
    }
}
