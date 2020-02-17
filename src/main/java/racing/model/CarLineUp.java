package racing.model;

import racing.view.OutputView;

import java.util.List;
import java.util.ArrayList;

public class CarLineUp {
    public static final String COMMA = ", ";
    public static final int SINGLE_SIZE = 1;

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
            OutputView.printCurrentDashResult(car.getName(), car.getPosition());
        }
    }

    public String findWinner() {
        Car topPositionCar = findTopPositionCar();
        StringBuilder winners = new StringBuilder();
        winners.append(topPositionCar);
        for (Car car : lineUp){
            findAnotherWinners(topPositionCar, winners, car);
        }
        return winners.toString();
    }

    private void findAnotherWinners(Car topPositionCar, StringBuilder winners, Car car) {
        if (isAnotherWinner(topPositionCar, car)){
            winners.append(COMMA);
            winners.append(car);
        }
    }

    private boolean isAnotherWinner(Car topPositionCar, Car car) {
        return !car.equals(topPositionCar) && car.getPosition().equals(topPositionCar.getPosition());
    }

    private Car findTopPositionCar() {
        Car topPositionCar = lineUp.get(0);
        int lineUpSize = lineUp.size();
        if (isSingleLineUp(lineUpSize)){
            return topPositionCar;
        }
        for (int index  =  1; index < lineUpSize; index++){
            topPositionCar = topPositionCar.getBiggerPositionCar(lineUp.get(index));
        }
        return topPositionCar;
    }

    private boolean isSingleLineUp(int lineUpSize) {
        return lineUpSize == SINGLE_SIZE;
    }

    @Override
    public String toString(){
        return lineUp.toString();
    }
}
