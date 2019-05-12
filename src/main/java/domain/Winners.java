package domain;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by Heebg
 * User: heebg
 * Date: 2019-05-12
 */
public class Winners {
    private int maxPosition;
    private List<Car> winners;

    public Winners(List<Car> raceCars) {
        this.maxPosition = setMaxPosition(raceCars);
        this.winners = setWinner(raceCars);
    }

    private int setMaxPosition(List<Car> raceCars) {
        Car maxCar = raceCars.stream().max(Car::compareTo).get();
        int max = Const.CAR_OBJ_INIT_POSITION;
        while (maxCar.isGreater(max)) {
            ++max;
        }
        return max;
    }

    private List<Car> setWinner(List<Car> raceCars) {
        winners = raceCars.stream().filter(x -> x.isMatchPosition(maxPosition))
                .collect(toList());
        return winners;
    }

    public String getWinnersName() {
        List<String> names = new ArrayList<>();
        winners.stream().forEach(x -> names.add(x.toString().split(" ")[0]));
        return String.join(",", names);
    }

    public boolean isMatchMaxPosition(int position) {
        if (maxPosition == position) {
            return true;
        }
        return false;
    }


}
