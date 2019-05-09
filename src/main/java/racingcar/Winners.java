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

    public void announceWinners() {
        System.out.println(String.join(", ", this.listOfWinners) + " 가 우승했습니다!");
    }


}
