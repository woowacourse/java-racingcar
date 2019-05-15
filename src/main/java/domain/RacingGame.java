package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RacingGame {
    private final Random rand = new Random();

    private final List<Car> cars;
    private int leftTrials;

    public RacingGame(List<Car> cars, int numTrials) {
        this.cars = new ArrayList(cars); // 밖에서 수정해도 영향을 받지 않도록
        this.leftTrials = numTrials;
    }

    public List<MovedCar> playTrial(Predicate<Integer> strategy) {
        if (leftTrials == 0) {
            return new ArrayList<>();
        }
        leftTrials--;

        return cars.stream().map((car) -> tryMove(car, strategy))
                .collect(Collectors.toList());
    }

    private MovedCar tryMove(Car car, Predicate<Integer> strategy) {
        return strategy.test(rand.nextInt(MoveStrategy.MAX_NUM)) ? car.move() : car.getMovedCar();
    }

    public boolean isFinished() {
        return leftTrials == 0;
    }
}
