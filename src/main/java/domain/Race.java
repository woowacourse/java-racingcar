package domain;

import util.Util;

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
}
