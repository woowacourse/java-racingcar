package racing.model;

import java.util.*;

public class CarLineUp {

    private final PriorityQueue<Car> lineUp = new PriorityQueue<>();

    public CarLineUp(final String[] lineUp) {
        this(lineUp, new int[lineUp.length]);
    }

    public CarLineUp(final String[] lineUp, final int[] positions) {
        checkCarNamesOrPositionsNull(lineUp, positions);
        for (int index = 0; index < lineUp.length; index++){
            this.lineUp.add(new Car(lineUp[index], positions[index]));
        }
        checkDuplicatedName();
    }

    private void checkCarNamesOrPositionsNull(final String[] lineUp, final int[] positions) {
        if (lineUp == null | positions == null){
            throw new NullPointerException("차 이름이 입력되지 않았습니다.");
        }
    }

    private void checkDuplicatedName() {
        Set<Car> set = new HashSet<>(lineUp);
        if (set.size() < lineUp.size()) {
            throw new IllegalArgumentException("차 이름이 중복되었습니다.");
        }
    }

    public List<Car> findWinner() {
        Car topPositionCar = findTopPositionCar();
        List<Car> winners = new ArrayList<>();
        for (Car car : lineUp) {
            isWinnerPosition(topPositionCar, winners, car);
        }
        return winners;
    }

    private void isWinnerPosition(Car topPositionCar, List<Car> winners, Car car) {
        if (car.isSamePosition(topPositionCar)) {
            winners.add(car);
        }
    }

    public Car findTopPositionCar() {
        return lineUp.peek();
    }

    public PriorityQueue<Car> getLineUp() {
        return lineUp;
    }

    @Override
    public String toString() {
        return lineUp.toString();
    }


}
