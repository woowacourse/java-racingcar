package racing.model;

import racing.view.OutputView;

import java.util.List;
import java.util.ArrayList;

public class CarLineUp {
    private List<Car> lineUp = new ArrayList<>();

    public void add(Car car){
        lineUp.add(car);
    }

    public boolean isContainAlready(String name){
        for (Car carAlready : lineUp){
            if (carAlready.isNameEqual(name)){
                return true;
            }
        }return false;
    }

    public void raceOneTime() {
        for (Car car : lineUp){
            car.move(new RandomNo());
            OutputView.printCurrentDashResult(car.getCurrentResult());
        }
    }

    public String findWinner() {
        Position topPosition = lineUp.get(0).getPosition();
        for (int index = 1; index < lineUp.size(); index++){
            topPosition = topPosition.comparePositionSize(lineUp.get(index).getPosition());
        }

        StringBuilder winner = new StringBuilder();
        for (Car car : lineUp){
            if (car.getPosition().equals(topPosition)){
                winner.append(", ");
                winner.append(car);
            }
        }
        return winner.toString();
    }
}
