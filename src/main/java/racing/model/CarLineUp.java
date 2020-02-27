package racing.model;


import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class CarLineUp {
    public static final int SINGLE_SIZE = 1;

    private final PriorityQueue<Car> lineUp = new PriorityQueue<>();

    public void add(final Car car) {
        checkNameDuplicate(car);
        lineUp.add(car);
    }

    private void checkNameDuplicate(Car car) {
        if (isAlready(car)) {
            throw new IllegalArgumentException("차 이름이 중복되었습니다.");
        }
    }

    private boolean isAlready(final Car car) {
        return lineUp.stream()
                .anyMatch(c -> c.isNameEqual(car));
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
        if (!car.isSamePosition(topPositionCar)) {
            winners.add(car);
        }
    }


    @Override
    public String toString() {
        return lineUp.toString();
    }

    public Car findTopPositionCar() {
        return lineUp.peek();
    }

    public PriorityQueue<Car> getLineUp() {
        return lineUp;
    }
}
