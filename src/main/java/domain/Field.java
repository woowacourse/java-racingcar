package domain;

import java.util.ArrayList;
import java.util.List;
import utils.NumberGenerator;

public class Field {
    private final CarGroup carGroup;
    private final StringBuilder record;
    private final NumberGenerator numberGenerator;

    public Field(CarGroup carGroup, NumberGenerator numberGenerator) {
        this.carGroup = carGroup;
        this.record = new StringBuilder("\n실행 결과\n");
        this.numberGenerator = numberGenerator;
    }

    public void race(int numberOfAttempts) {
        List<Car> cars = carGroup.getAllCars();
        for (int i = 0; i < numberOfAttempts; i++) {
            runSingleAttempt(cars);
            log(cars);
        }
    }

    private void runSingleAttempt(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = numberGenerator.getNumber();
            car.move(randomNumber);
        }
    }

    private void log(List<Car> cars) {
        for (Car car : cars) {
            record.append(car.toString());
            record.append("\n");
        }
        record.append("\n");
    }

    public String getResult() {
        List<Car> winners = carGroup.getWinners();
        List<String> winnerNames = new ArrayList<>();
        for (Car winner : winners) {
            winnerNames.add(winner.getName());
        }
        String winnerResult = String.join(", ", winnerNames).concat("가 최종 우승했습니다.");
        return record.append(winnerResult).toString();
    }
}
