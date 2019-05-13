package racingcargame.model;

import java.util.List;
import java.util.stream.Collectors;

public class Round {
    private static final int MAX_BOUND = 10;

    private final List<String> roundResult;

    Round(List<Car> cars){
        this.roundResult = round(cars);
    }

    private List<String> round(List<Car> cars) {
        cars.forEach(car -> car.move(getRandomNo()));
        return cars.stream()
                .map(car -> car.getName() + " : " + positionResult(car.getPosition()))
                .collect(Collectors.toList());
    }

    private int getRandomNo() {
        return (int) (Math.random() * MAX_BOUND);
    }

    private String positionResult(int position){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++){
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String result : roundResult){
            stringBuilder.append(result)
                    .append("\n");
        }
        return stringBuilder.toString();
    }
}
