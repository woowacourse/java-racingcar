package racing.model;


import java.util.List;
import java.util.ArrayList;

public class CarLineUp {
    public static final int SINGLE_SIZE = 1;

    private final List<Car> lineUp = new ArrayList<>();

    public void add(final Car car){
        lineUp.add(car);
    }

    public boolean isAlready(final String name){
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
        }
    }

    public void raceOneTime(final int number) {
        RandomNo randomNo = new RandomNo(number);
        for (Car car : lineUp){
            car.move(randomNo);
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
