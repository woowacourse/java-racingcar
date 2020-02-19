package racing.model;


import java.util.List;
import java.util.ArrayList;

public class CarLineUp {
    public static final int SINGLE_SIZE = 1;

    private final List<Car> lineUp = new ArrayList<>();

    public void add(final Car car){
        lineUp.add(car);
    }

    public boolean isAlready(final Car car){
        return lineUp.stream()
                .anyMatch(c -> c.isNameEqual(car));
    }

    public void raceOneTime() {
        RandomNo randomNo = new RandomNo();
        for (Car car : lineUp){
            car.move(randomNo.getNumber());
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

    private void findAnotherWinners(final Car topPositionCar, final List<Car> winners, final Car car) {
        if (isAnotherWinner(topPositionCar, car)){
            winners.add(car);
        }
    }

    private boolean isAnotherWinner(final Car topPositionCar, final Car car) {
        return !car.equals(topPositionCar) && car.isSamePosition(topPositionCar);
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

    private boolean isSingleLineUp(final int lineUpSize) {
        return lineUpSize == SINGLE_SIZE;
    }

    @Override
    public String toString(){
        return lineUp.toString();
    }

    public List<Car> getLineUp() {
        return lineUp;
    }
}
