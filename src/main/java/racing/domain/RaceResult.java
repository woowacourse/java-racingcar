package racing.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RaceResult {
    List<Car> cars;
    List<Car> winners;

    public RaceResult(List<Car> cars) {
        this.cars = cars;
        winners = new ArrayList<>();
    }

    public void judgeWinners() {
        Car winner = findWinner();
        Car curCar;
        Iterator<Car> it = cars.iterator();
        while(it.hasNext()) {
            curCar = it.next();
            if(curCar.isSameRank(winner)) {
                winners.add(curCar);
            }
        }
        System.out.println(winners);
    }

    public Car findWinner() {
        Iterator<Car> it = cars.iterator();
        Car winner = it.next();
        Car curCar;
        while(it.hasNext()) {
            curCar = it.next();
            if (curCar.isFartherThan(winner)) {
                winner = curCar;
            }
        }
        return winner;
    }
}
