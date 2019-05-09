package racingcar;

import java.util.*;

public class Winners {
    private List<String> listOfWinners;
    /*
    public void decideWinners(Cars cars) {
        int maxPosition = ;
        this.decideWinningCars(cars, maxPosition);
    }
     */
    public void decideWinners(Cars cars){
        this.listOfWinners = cars.decideWinners(cars.decideMaxPosition());
    }


}
