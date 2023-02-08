package service;

import domain.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGame {
    private static final int RANDOM_START_INCLUSIVE = 0;
    private static final int RANDOM_END_INCLUSIVE = 9;
    private static final int PROCESS_MOVING_MIN_NUMBER = 4;

    private List<Car> cars;
    private NumberGenerator numberGenerator;

    public RacingGame(NumberGenerator numberGenerator) {
        this.cars = new ArrayList<>();
        this.numberGenerator = numberGenerator;
    }

    public void generateCars(List<String> carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void processAllCars() {
        for (Car car : cars) {
            int random = numberGenerator.generate(0, 9);
            process(car, random);
        }
    }

    private void process(Car car, int value) {
        validateProcessValue(value);
        if (value >= PROCESS_MOVING_MIN_NUMBER) {
            car.move();
        }
    }

    private void validateProcessValue(int value) {
        if (value < RANDOM_START_INCLUSIVE || value > RANDOM_END_INCLUSIVE) {
            throw new IllegalArgumentException("자동차 전진을 위한 값은 지정된 범위 내여야 합니다.");
        }
    }

    public List<String> decisionWinners(){
        List<String> winners = new ArrayList<>();
        int topPoint = cars.stream().mapToInt(c->c.getPosition()).max().getAsInt();
        for (Car car: cars){
            if(car.getPosition() == topPoint){
                winners.add(car.getName());
            }
        }
        return Collections.unmodifiableList(winners);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
