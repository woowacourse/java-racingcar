package racing.domain;

import racing.view.OutputView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RaceResult {
    private List<Car> cars;
    private List<Car> winners;

    public RaceResult(List<Car> cars) {
        this.cars = cars;
        winners = new ArrayList<>();
    }

    public void judgeWinners() {
        Car winner = findWinner();
        Car curCar;
        Iterator<Car> it = cars.iterator();
        while (it.hasNext()) {
            curCar = it.next();
            if (curCar.isSameRank(winner)) {
                winners.add(curCar);
            }
        }
    }

    public Car findWinner() {
        Iterator<Car> it = cars.iterator();
        Car winner = it.next();
        Car curCar;
        while (it.hasNext()) {
            curCar = it.next();
            if (curCar.isFartherThan(winner)) {
                winner = curCar;
            }
        }
        return winner;
    }

    public void printWinners() {
        OutputView.printResult(winners);
    }

}
