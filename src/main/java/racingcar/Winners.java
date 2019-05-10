package racingcar;

import java.util.*;

public class Winners {
    private List<String> listOfWinners;

    public void decideWinners(Cars cars){
        this.listOfWinners = cars.decideWinners(cars.decideMaxPosition());
    }

    public String getWinners() {
        return String.join(", ", listOfWinners);
    }

}
