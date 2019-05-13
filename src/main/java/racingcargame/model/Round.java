package racingcargame.model;

import java.util.ArrayList;
import java.util.List;

public class Round {
    private static final int MAX_BOUND = 10;
    private static final String POSITION_DISPLAY = "-";
    private static final String CAR_DELIMITER = " : ";
    private static final String NEXT_LINE = "\n";

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
                    .append(CAR_DELIMITER)
                    .append(positionResult(result.getPosition()))
                    .append(NEXT_LINE);
        }
        return stringBuilder.toString();
    }

    private String positionResult(int position){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++){
            stringBuilder.append(POSITION_DISPLAY);
        }
        return stringBuilder.toString();
    }
}
