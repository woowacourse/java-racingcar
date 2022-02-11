package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RacingCars {
    List<RacingCar> racingCars;
    
    public RacingCars(){
        racingCars = new ArrayList<>();
    }
    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public RacingCar getRacingCarMaxPosition(){
        return racingCars.stream().max(Comparator.comparingInt(RacingCar::getPosition)).get();
    }
}
