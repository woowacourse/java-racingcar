package racing.model;

import racing.view.OutputView;

import java.util.List;
import java.util.ArrayList;

public class CarLineUp {
    public static final int SINGLE_SIZE = 1;

    private List<Car> lineUp = new ArrayList<>();

    public void add(Car car){
        lineUp.add(car);
    }

    public boolean isAlready(String name){
        int count = (int)lineUp.stream()
                .filter(c -> c.isNameEqual(name))
                .count();
        if (count == 0){
            return false;
        }
        return true;

    }

    public void raceOneTime() {
        for (Car car : lineUp){
            car.move(new RandomNo());
            OutputView.printCurrentDashResult(car.getName(), car.getPosition());
        }
    }

    public List<Car> findWinner() {
        Car topPositionCar = findTopPositionCar();
        List<Car> winners = new ArrayList<>();
        winners.add(topPositionCar);
        for (Car car : lineUp){
            findAnotherWinners(topPositionCar, winners, car);
        }
        return winners;
    }

    private void findAnotherWinners(Car topPositionCar, List<Car> winners, Car car) {
        if (isAnotherWinner(topPositionCar, car)){
            winners.add(car);
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
