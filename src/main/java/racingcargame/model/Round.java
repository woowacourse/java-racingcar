package racingcargame.model;

import java.util.ArrayList;
import java.util.List;

public class Round {
    private static final int MAX_BOUND = 10;

    private final List<Car> roundResult;

    Round(List<Car> cars){
        this.roundResult = round(cars);
    }

    private List<Car> round(List<Car> cars) {
        cars.forEach(car -> car.move(getRandomNo()));
        List<Car> roundResult = new ArrayList<>();
        for (Car car : cars) {
            roundResult.add(new Car(car.getName(), car.getPosition()));
        }
        return roundResult;
    }

    private int getRandomNo() {
        return (int) (Math.random() * MAX_BOUND);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car result : roundResult){
            stringBuilder.append(result.getName())
                    .append(" : ")
                    .append(positionResult(result.getPosition()))
                    .append("\n");
        }
        return stringBuilder.toString();
    }

    private String positionResult(int position){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++){
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }
}
